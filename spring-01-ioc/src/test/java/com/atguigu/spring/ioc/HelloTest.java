package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.User;
import com.atguigu.spring.ioc.dao.DeliveryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * ClassName: HelloTest
 * Package: com.atguigu.spring.ioc
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/28 16:42
 * @Version 19
 */

@SpringBootTest
public class HelloTest {

    @Autowired
    User user;

    @Autowired
    DeliveryDao deliveryDao;

    @Test
    void test02() {
        String string = UUID.randomUUID().toString();
        System.out.println("string: " + string);
    }

    @Test
    void test01() {
        deliveryDao.saveDelivery();
    }



}
