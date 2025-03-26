package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: UserCpnfig
 * Package: com.atguigu.spring.ioc.config
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/26 16:36
 * @Version 19
 */

@Configuration
public class UserConfig {


    @Bean(initMethod = "initUser",destroyMethod = "destroyUser")
    public User user() {
        return new User();
    }

}
