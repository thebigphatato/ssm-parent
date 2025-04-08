package com.atguigu.spring.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 操作数据库：
 * 1、导入包： spring-boot-starter-data-jdbc、mysql-connector-java
 * 2、配置数据库连接信息：在application.properties中的spring.datasource.*
 * 3、可以直接使用 DataSource、 JdbcTemplate
 */



@SpringBootApplication
public class Spring03TxApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring03TxApplication.class, args);
    }

}
