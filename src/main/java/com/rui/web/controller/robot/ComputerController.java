package com.rui.web.controller.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.model.ComputerModel;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.cache.EntityCache;
import com.rui.web.common.utils.DateUtils;
import com.rui.web.controller.base.AdminBaseController;
import com.rui.web.controller.robot.util.BaseDao;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.sql.Timestamp;
import java.util.HashMap;
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
    /**
     * 监听的端口
     * @author : zhuxueke
     * @since : 2018/1/23 17:27
     */
    @Value("${server.port}")
    private String port;

    @Autowired
    IComputerService computerService;

    @RequestMapping(value = "run")
    @ResponseBody
    String ApplicationRun(String pwd, String name){
        boolean state = false;
        try{
//            ComputerQuery query = new ComputerQuery();
//            query.setPwd(pwd);
//            if(name != null){
//                query.setName(name);
//            }else{
//                //获取当前系统用户名
//                query.setName(System.getenv("USERNAME"));
//            }
//            if(computerDomain != null){
//                computerDomain.setIp(InetAddress.getLocalHost().getHostAddress().toString());
//                computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//                computerService.update(computerDomain);
//            }else{
//                //创建用户 密码默认 123456
//                computerDomain = new ComputerDomain();
//                computerDomain.setId(computerService.getMaxId() + 1);
//                computerDomain.setIp(InetAddress.getLocalHost().getHostAddress().toString());
//                computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//                computerDomain.setName(query.getName());
//                computerDomain.setPwd("123456");
//                computerService.create(computerDomain);
//            }
            ServerSocket serverSocket = SingleServerSocket.getInstance(Integer.parseInt(port));
            state = true;
            while(true){
                new ServerSocketThread(serverSocket.accept()).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(state){
            return successObjectStr("启动成功!");
        }else{
            return errorObjectStr("启动失败!");
        }
    }

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
        try {
            ComputerDomain domain = computerService.getOne(computerQuery);
            if(domain == null){
                return errorObjectStr("用户名或密码错误!");
            }else{
                // 设置 user 过期时间为 30min
                cacheManager.putCache("user", new EntityCache(domain, DateUtils.getFutureDate(30),System.currentTimeMillis()));
                // 保持登录
                // 目前为本地缓存，正确方式应为服务器缓存
//                if(online){
//                    cacheManager.putCache("uname", new EntityCache(domain.getName(),0L,0L));
//                    cacheManager.putCache("upwd", new EntityCache(domain.getPwd(),0L,0L));
//                }else{
//                    cacheManager.clearByKey("uname");
//                    cacheManager.clearByKey("upwd");
//                }
            }
        }catch (Exception e){
            logger.info("登录失败:" + e.getMessage());
            // 向服务端发送错误信息
        }
        return successObjectStr("登录成功!");
    }

    /**
     * index 页面
     * @author : zhuxueke
     * @since : 2018/1/23 16:23
     */
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("login/index");
        modelAndView.addObject("com",(ComputerDomain) cacheManager.getCacheByKey("user").getDatas());
        // others
        return modelAndView;
    }
}