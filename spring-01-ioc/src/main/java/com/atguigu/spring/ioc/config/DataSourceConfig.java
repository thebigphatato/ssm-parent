package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ClassName: DataSourceConfig
 * Package: com.atguigu.spring.ioc.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/26 14:48
 * @Version 19
 */

@Profile("dev")// 整个类整体激活
@Configuration
public class DataSourceConfig {



    // 1、定义环境标识：dev，test,prod
    // 2、激活环境表示：
    //      明确告诉Spring当前处于什么环境
    //      你要不说环境，就是default环境

    // 利用条件注解，只在某种环境下激活一个组件

    @Profile({"dev","default"})// @Profile("环境标识")。当这个环境被激活的时候，才会加入如下组件。环境标识由你定义
    @Bean
    public MyDataSource dev() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/dev");//快捷键alt+insert快速生成方法
        myDataSource.setUsername("dev_user");
        myDataSource.setPassword("dev_pwd");

        return myDataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/test");//快捷键alt+insert快速生成方法
        myDataSource.setUsername("test_user");
        myDataSource.setPassword("test_pwd");

        return myDataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/prod");//快捷键alt+insert快速生成方法
        myDataSource.setUsername("prod_user");
        myDataSource.setPassword("prod_pwd");

        return myDataSource;

    }
}
