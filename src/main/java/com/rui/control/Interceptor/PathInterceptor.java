package com.rui.control.Interceptor;

import com.rui.web.cache.CacheManagerImpl;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置路径
 * @author : zhuxueke
 * @since : 2017-12-22 9:39
 **/
public class PathInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        // 设置绝对路径
        request.setAttribute("basePath", basePath);
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        CacheManagerImpl cacheManager = new CacheManagerImpl();
//        // 判断用户是否登录
//        if(!cacheManager.isContain("user")){
//            //进入login页面
//            response.sendRedirect(  "/computer/login");
//        }
        return super.preHandle(request, response, handler);
    }
}
