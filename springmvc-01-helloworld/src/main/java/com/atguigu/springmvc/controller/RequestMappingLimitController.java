package com.atguigu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thebigpotato
 * @create 2025-04-17-16:06
 */

//@ResponseBody // 如果标在类上，则类中的每个方法都有了responseBody
//@Controller
@RestController // 这一个注解相当于上面标两个注解一样的效果,前后分离开发就用这个注解
public class RequestMappingLimitController {

    /**
     * 请求方式：
     *      GET,HEAD,POST,PUT,PATCH,DELETE,OPTIONS,TRACE
     *  Postman中测试
     */
    @RequestMapping(value = "/test01",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String test01() {
        return "test01";
    }

    /**
     * 请求参数：params = {"username","age"}
     * 参数是在网址后面加？然后写参数,多个参数用&连接，例如http://localhost:8888/test02?age=18&username=zhs&gender=0
     * 1、username：表示请求必须包含username参数
     * 2、age=18：  表示请求参数中必须包含age=18的参数
     * 3、gender!=1 表示请求中参数不能包含gender=1的参数
     * @return
     */
    @RequestMapping(value = "/test02",params = {"age=18","username","gender!=1"})
    public String test02() {
        return "test02";
    }


    /**
     * 请求头：headers = {"haha"}
     * 请求头必须得在Postman中加入，在浏览器的网址上打不了
     * 1、haha：表示请求中必须包含名为 haha 的请求头
     * 2、hehe!=1：表示请求头中中的 hehe 不能是1；不带hehe表示hehe=0
     * @return
     */
    @RequestMapping(value = "/test03",headers = "haha")
    public String test03() {
        return "test03";
    }

    /**
     * 请求内容类型：consumes = {"application/json"};消费什么数据；
     * Media Type：媒体类型
     * 1、application/json：表示浏览器必须携带json格式的数据
     *
     * @return
     */
    @RequestMapping(value = "/test04",consumes = "application/json")
    public String test04() {
        return "test04";
    }

    /**
     * 响应内容类型：produces = {"text/plain;charset=utf-8"};生产什么数据；
     * @return
     */
    @RequestMapping(value = "/test05",produces = "text/html;charset=utf-8")
    public String test05() {
        return "<h1>你好，张三</h1>";
    }


}
