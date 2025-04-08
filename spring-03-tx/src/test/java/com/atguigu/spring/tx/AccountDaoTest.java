package com.atguigu.spring.tx;

import com.atguigu.spring.tx.dao.AccountDao;
import com.atguigu.spring.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: AccountDaoTest
 * Package: com.atguigu.spring.tx
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/8 16:38
 * @Version 19
 */
@SpringBootTest
public class AccountDaoTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    //测试结账
    @Test
    void testCheckout() {
//        userService.checkout("zhangsan",1,3);
        userService.checkout("wangwu",2,2);

    }

    @Test
    void testUpdateBalanceByusername() {
        accountDao.updateBalanceByUsername("zhangsan", BigDecimal.valueOf(100.0));
    }
}

