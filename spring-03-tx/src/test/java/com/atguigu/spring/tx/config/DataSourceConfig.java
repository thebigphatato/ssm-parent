package com.atguigu.spring.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

/**
 * ClassName: DataSourceConfig
 * Package: com.atguigu.spring.tx.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/30 15:29
 * @Version 19
 */

//@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    // SpringBoot默认约定：用户配了的用用户的，没配的用默认的
    @Bean
    DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }

}
