package com.atguigu.spring.aop.service.impl;

import com.atguigu.spring.aop.service.UserService;

/**
 * @author thebigpotato
 * @create 2025-03-29-22:54
 */
public class UserServiceImpl implements UserService {

    // ctrl + i快捷键多使用，是你一直想要的快捷键
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");

    }
}
