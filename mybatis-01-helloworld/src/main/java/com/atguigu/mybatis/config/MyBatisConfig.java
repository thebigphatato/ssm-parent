package com.atguigu.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.PropertyPermission;

/**
 * ClassName: MyBatisConfig
 * Package: com.atguigu.mybatis.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/26 20:43
 * @Version 19
 */


@Configuration
public class MyBatisConfig {

    @Bean
    PageInterceptor pageInterceptor() {
//     1、创建PageInterceptor对象（分页插件对象）
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 2、配置参数
        // .............
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        // 3、

        return  pageInterceptor;

    }
}