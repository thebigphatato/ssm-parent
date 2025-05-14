package com.atguigu.practice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: MyHandlerInterceptor0
 * Package: com.atguigu.practice.interceptor
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/7 17:26
 * @Version 19
 */

@Component // 拦截器还需要配置(告诉SpringMVC,这个拦截器主要拦截什么请求)
public class MyHandlerInterceptor0 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyHandlerInterceptor0.preHandle");
        //放行true,拦截false
        // 这儿可以写权限检查的逻辑 例如String username = request.getParameter("username")看看用户名有没有权限
//        response.getWriter().write("No Permission!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyHandlerInterceptor0.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("MyHandlerInterceptor0.afterCompletion");

    }



}
