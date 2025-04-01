package com.atguigu.spring.aop.service;

import com.atguigu.spring.aop.annotation.MyAn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author thebigpotato
 * @create 2025-03-29-22:54
 */


public interface UserService {

    void saveUser();

    void getUserHaha(int i,int j);

    void updateUser();
}
