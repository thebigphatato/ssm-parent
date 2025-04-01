package com.atguigu.spring.aop.service.impl;

import com.atguigu.spring.aop.annotation.MyAn;
import com.atguigu.spring.aop.service.UserService;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

/**
 * @author thebigpotato
 * @create 2025-03-29-22:54
 */
@MyAn
@Component
public class UserServiceImpl implements UserService {

    // ctrl + i快捷键多使用，是你一直想要的快捷键
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");

    }

    @Override
    public void getUserHaha(int i, int j) {
        System.out.println("业务：查询业务");
    }

    @MyAn
    @Override
    public void updateUser() {

        System.out.println("哈哈哈.....有@MyAn");
    }
}
