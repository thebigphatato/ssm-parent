package com.atguigu.spring.ioc.controller;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.service.UserService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.atguigu.spring.ioc.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 21:10
 * @Version 19
 */

@ToString
@Data
@Controller
public class UserController {
    /**
     * 自动装配流程（先按照类型，再按照名称）
     * 1.按照类型，找到这个组件;
     *      1.0：有且找到一个，直接注入， 名字无所谓
     *      1.1：如果找到多个，再按照名称去找;变量名就是名字（新版）
     *              1.1.1 如果找到。直接注入
     *              1.1.2 如果找不到，报错
     *
     */

    @Autowired //自动装配：原理：Spring 调用 容器.getBean()
    UserService userService;

    @Autowired
    Person lisi;

    @Autowired //
    List<Person> personList;

    @Autowired
    Map<String,Person> personMap;

}
