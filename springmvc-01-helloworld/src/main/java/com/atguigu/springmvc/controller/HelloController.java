package com.atguigu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.atguigu.springmvc.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/16 17:25
 * @Version 19
 */

//@ResponseBody // 如果标在类上，则类中的每个方法都有了responseBody
//@Controller
@RestController // 这一个注解相当于上面标两个注解一样的效果,前后分离开发就用这个注解
//@Controller //告诉Spring这是一个控制器(处理请求的组件)
public class HelloController {

    /**
     *
     *
     * 精确路径必须全局唯一
     * 路径位置通配符： 多个都能匹配上，那就精确优先
     *      *： 匹配任意多个字符（0~N个字符）; 不能匹配多个路径
     *      **：匹配任意多层路径; 双星不能放路径中间,但问号和单星可以
     *      ？：匹配任意单个字符（只能是1个字符）
     *   精确程度：完全匹配 > ? > * > **
     * @return
     */
    @ResponseBody //把返回值放到响应体中,每次请求进来都执行目标方法
    @RequestMapping("/hello")
    public String handle() {
        System.out.println("handle()方法执行了！");
        return "Hello,Spring MVC! 你好！~~~";//默认认为返回值是跳到一个页面
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String handle01() {
        System.out.println("handle01方法执行了！");
        return "handle01";
    }

    @ResponseBody
    @RequestMapping("/hell*")
    public String handle02() {
        System.out.println("handle02方法执行了！");
        return "handle02";
    }

    @ResponseBody
    @RequestMapping("/hello/ **")
    public String handle03() {
        System.out.println("handle03方法执行了！");
        return "handle03";
    }




}
