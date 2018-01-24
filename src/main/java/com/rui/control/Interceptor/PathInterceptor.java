package com.rui.control.Interceptor;

import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.ServerSocket;

/**
 * 设置路径
 * @author : zhuxueke
 * @since : 2017-12-22 9:39
 **/
public class PathInterceptor extends HandlerInterceptorAdapter {

    /**
     * 监听的端口
     * @author : zhuxueke
     * @since : 2018/1/23 17:27
     */
    @Value("${server.port}")
    private String port;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        // 设置绝对路径
        request.setAttribute("basePath", basePath);
        super.postHandle(request, response, handler, modelAndView);
    }

}
