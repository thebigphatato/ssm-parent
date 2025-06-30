package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.atguigu.boot.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/30 13:06
 * @Version 19
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }


}
