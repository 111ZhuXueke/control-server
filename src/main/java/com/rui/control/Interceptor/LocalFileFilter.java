package com.rui.control.Interceptor;

import com.rui.control.service.IComputerService;
import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.cache.EntityCache;
import com.rui.web.controller.robot.util.Base64Utils;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  用户是否为第一次登录
 *  用户第一次登录后会在本地创建local.txt文件 ==》 信息为：当前计算机用户名 + 项目启动时间
 * @author : zhuxueke
 * @since : 2018-01-24 9:11
 **/
public class LocalFileFilter implements Filter {
    CacheManagerImpl cacheManager = new CacheManagerImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try{
            createFile();
            String servletPath = request.getServletPath();
            if(!servletPath.startsWith("/static/")){
                if(!servletPath.endsWith("computer/login") && !servletPath.endsWith("computer/login")){
                    // 判断用户是否登录
                    boolean state = cacheManager.isContain("user");
                    if(!state){
                        //进入login页面
                        response.sendRedirect("/computer/login");
                        return;
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("-------------------------过滤器已销毁-------------------------");
    }
    /**
     * 用于创建本地文件 == 》用户的唯一标识
     * @author : zhuxueke
     * @since : 2018/1/24 16:19
     */
    public void createFile() throws Exception{
        // 项目启动默认根据当前计算机管理员名称 进行启动
        // 如果计算机管理员名称在数据库存在多条
        // 则校验本地文件
        // 当前路径 ==》 路径为项目编译后的 classes 路径
//        String path = LocalFileFilter.class.getClassLoader().getResource("").getPath() + File.separator + "lcoal.txt";
        String path = "D:/lcoal.txt";
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            // 使用commons-codec的base64 加密字符串
            long var1 = new Date().getTime();
            String content = new String(Base64.encodeBase64(Base64Utils.getStr(var1).getBytes()));
            cacheManager.putCache("base64Str",new EntityCache(content,0L,0L));
            cacheManager.putCache("base64CreateTime",new EntityCache(var1,0L,0L));
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
