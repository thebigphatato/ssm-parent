package com.atguigu.springmvc.controller;

/**
 * ClassName: PageTestController
 * Package: com.atguigu.springmvc.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 10:34
 * @Version 19
 */

import com.atguigu.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * SpringBoot整合的SPringMVC默认不支持JSP
 * 1、引入 thymeleaf 作为模型引擎，渲染页面
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-thymeleaf</artifactId>
 *      </dependency>
 * 2、默认规则
 *      页面：src/main/resources/templates
 *      静态资源：src/main/resources/static
 */
@Controller // 开发服务端渲染引擎，这里为什么不用@RestController，因为rest是前后分离开发，现在是纯后端开发
public class PageTestController {


    //处理 / 请求，跳转到登录页
    @RequestMapping("/")
    public String index(){

        // thymeleaf 默认：去classpath:/templates/ 找页面，后缀为 .html
        // 页面地址 = classpath:/templates/ + 返回名字 + .html
        return "login"; // 返回值就是 页面名称(专业叫法叫视图名)
    }

    @RequestMapping("/login.mvc")
    public String login(String username,
                        String password,
                        // 模型就是页面要展示的所有数据
                        Model model) {
        System.out.println("用户登录：" + username + "," + password);

        // 去数据库查到登录的用户信息

        // 去数据库查到访客列表
        List<User> list = Arrays.asList(
                new User(1l,"张三",18),
                new User(2l,"张三2",28),
                new User(3l,"张三3",16),
                new User(4l,"张三4",12),
                new User(4l,"张三4",17),
                new User(4l,"张三4",28),
                new User(4l,"张三4",11),
                new User(4l,"张三4",38)

        );
        model.addAttribute("users", list);
        model.addAttribute("name",username);
        model.addAttribute("age",18);

        return "page/success";

    }
}
