package com.atguigu.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Representational State Transfer 表现层状态转移
 * 是一种软件架构风格
 * 完整理解：Resource Representational State Transfer
 * 使用资源名作为url，使用http的请求方式表示对资源的操作
 *
 */
@SpringBootApplication
public class SpringmvcRestfulCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcRestfulCrudApplication.class, args);
    }

}
