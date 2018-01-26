package com.rui.web.controller.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.model.ComputerModel;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.cache.EntityCache;
import com.rui.web.common.utils.DateUtils;
import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.model.InformationModel;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电脑用户控制层
 * @author : zhuxueke
 * @since : 2018-01-19 17:23
 **/
@Controller
@RequestMapping(value = "/computer")
public class ComputerController extends AdminBaseController{
    private static Logger logger = LoggerFactory.getLogger(ComputerController.class);
    CacheManagerImpl cacheManager = new CacheManagerImpl();

    @Autowired
    IComputerService computerService;

    /**
     * 监听的端口
     * @author : zhuxueke
     * @since : 2018/1/23 17:27
     */
    @Value("${server.port}")
    private String port;

    /**
     * to login
     * @author : zhuxueke
     * @since : 2018/1/23 15:22
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(ModelAndView modelAndView){
        if(cacheManager.getCacheByKey("uname") != null){
            modelAndView.addObject("uname", cacheManager.getCacheByKey("uname").getDatas());
        }
        if(cacheManager.getCacheByKey("upwd") != null){
            modelAndView.addObject("upwd", cacheManager.getCacheByKey("upwd").getDatas());
        }
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    /**
     * login 验证
     * @author : zhuxueke
     * @since : 2018/1/23 15:22
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String toLogin(ComputerQuery computerQuery,Boolean online){
        ComputerDomain computerDomain = null;
        try {
            String var1 = cacheManager.getCacheByKey("base64Str") != null ? cacheManager.getCacheByKey("base64Str").getDatas().toString() : null;
            if(var1 == null){
                computerQuery.setPwd(new String(Base64.encodeBase64(computerQuery.getPwd().getBytes())));
                computerDomain = computerService.getOne(computerQuery);
                if(computerDomain == null){
                    return errorObjectStr("用户名或密码错误!");
                }else{
                    // 更新时间
                    computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                }
            }else{
                // 未注册的用户登录
                // base64Str 只有在第一次启动项目才会存在
                String name = System.getenv("USERNAME");
                if(!computerQuery.getName().equals(name)){
                    return errorObjectStr("用户名输入有误!");
                }
                ComputerQuery query = new ComputerQuery();
                query.setPwd(null);
                query.setName(name);
                List<ComputerDomain> list = computerService.getList(query);
                boolean var2 = true;
                if(list.size() > 0){
                    for (ComputerDomain com: list) {
                        String var3 = com.getName() + com.getCreateTime();
                        // 若存在多个用户名相同的情况，则比较local.txt 中的信息，因受制于网络，所以 lcoal.txt 信息相同的情况概率几乎为0
                        String var4 = new String(Base64.encodeBase64(var3.getBytes()));
                        if(var4 .equals(var1)){
                            var2 = false;
                        }
                    }
                }
                computerDomain = new ComputerDomain();
                if(var2){
                    // 创建用户
                    Long time = (Long)cacheManager.getCacheByKey("base64CreateTime").getDatas();
                    computerDomain.setId(computerService.getMaxId() != null ? computerService.getMaxId() + 1 : 1);
                    computerDomain.setName(name);
                    // 默认密码为输入的密码
                    computerDomain.setPwd(new String(Base64.encodeBase64(computerQuery.getPwd().getBytes())));
                    computerDomain.setLastIp(computerDomain.getIp());
                    computerDomain.setIp(InetAddress.getLocalHost().getHostAddress().toString());
                    computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                    computerDomain.setCreateTime(new Timestamp(time));
                    computerDomain.setMac(var1);
                    computerDomain.setPort("18888");
                }else{
                    // 若存在相同数据、创建时间为当前时间
                    computerDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
                }
                computerService.create(computerDomain);
                // 创建成功，移除 加密信息和创建时间
                cacheManager.clearByKey("base64Str");
                cacheManager.clearByKey("base64CreateTime");
            }
            // 设置 user 过期时间为 30min
            cacheManager.putCache("user", new EntityCache(computerDomain, DateUtils.getFutureDate(30),System.currentTimeMillis()));
        }catch (Exception e){
            logger.info("登录失败:" + e.getMessage());
            // 向服务端发送错误信息
            e.printStackTrace();
        }
        return successObjectStr("登录成功!");

    }

    /**
     * index 页面
     * @author : zhuxueke
     * @since : 2018/1/23 16:23
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("login/index");
        modelAndView.addObject("com",(ComputerDomain) cacheManager.getCacheByKey("user").getDatas());
        return modelAndView;
    }
    /**
     * welcome 页面 ==> 我的桌面
     * @author : zhuxueke
     * @since : 2018/1/26 14:11
     */
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("login/welcome");
        InformationModel info = computerService.getComputerInfo();
        info.setSessionId(request.getRequestedSessionId());
        modelAndView.addObject("info", info);
        modelAndView.addObject("welcome", getUser());
        return modelAndView;
    }

    /**
     * 退出
     * @author : zhuxueke
     * @since : 2018/1/26 15:22
     */
    @RequestMapping(value = "/signout",method = RequestMethod.GET)
    public ModelAndView signout(){
        ModelAndView modelAndView = new ModelAndView();
        cacheManager.clearAll();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }
}