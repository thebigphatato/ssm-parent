package com.atguigu.practice.config;

import com.atguigu.practice.interceptor.MyHandlerInterceptor0;
import com.atguigu.practice.interceptor.MyHandlerInterceptor1;
import com.atguigu.practice.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MySpringMVCConfig
 * Package: com.atguigu.practice.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/7 17:32
 * @Version 19
 */

/**
 * 1、容器中需要有这样一个组件：WebMvcConfigurer  有下面两种方法实现它
 *      1、@Bean 放一个 WebMvcConfigurer
 *      2、配置类实现WebMvcConfigurer
 */
@Configuration //专门对SpringMVC底层做一些配置
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor0 myHandlerInterceptor0;

    @Autowired
    MyHandlerInterceptor1 myHandlerInterceptor1;

    @Autowired
    MyHandlerInterceptor2 myHandlerInterceptor2;

//    @Bean
//    WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                WebMvcConfigurer.super.addInterceptors(registry);
//            }
//        };
//    }

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor0)
                .addPathPatterns("/**");//拦截所有请求

                registry.addInterceptor(myHandlerInterceptor1)
                        .addPathPatterns("/**");
                registry.addInterceptor(myHandlerInterceptor2)
                        .addPathPatterns("/employee/**");



    }
}
