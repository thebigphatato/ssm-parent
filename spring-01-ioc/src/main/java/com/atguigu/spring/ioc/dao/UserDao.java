package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.bean.Dog;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserDao
 * Package: dao
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 21:12
 * @Version 19
 */
@ToString
@Repository
public class UserDao {

    Dog dog;
    /**
     * Spring家族推荐：构造器注入
     */
    // Spring 自动去容器中找到构造器需要的所有参数的组件值。
//    public UserDao(Dog dog.properties) {
//        System.out.println("UserDap...有参构造器：" + dog.properties);
//        this.haha = dog.properties;
//    }

    @Autowired
    public void setDog(Dog dog) {
        System.out.println("setDog..." + dog);
        this.dog = dog;
    }

}
