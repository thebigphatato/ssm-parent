package com.atguigu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: HelloController
 * Package: com.atguigu.springmvc.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/16 17:25
 * @Version 19
 */

@Controller //告诉Spring这是一个控制器(处理请求的组件)
public class HelloController {

    /**
     * 路径位置通配符：
     *      *： 匹配任意多个字符
     *      **：匹配任意多层路径
     *      ？：匹配任意单个字符
     * @return
     */
    @ResponseBody //把返回值放到响应体中,每次请求进来都执行目标方法
    @RequestMapping("/hello")
    public String handle() {
        return "Hello,Spring MVC! 你好！~~~";//默认认为返回值是跳到一个页面
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String handle01() {
        return "Hello,Spring MVC! 你好！~~~";
    }
}
