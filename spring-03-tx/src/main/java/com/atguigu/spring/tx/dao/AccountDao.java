package com.atguigu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author thebigpotato
 * @create 2025-04-03-22:53
 */

@Component
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 按照username扣减账户余额
     * @param username
     * @param delta
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 5) //REQUIRED表示和大事务共用一个事务
    //传播行为：参数设置项属性：如果小事务和大事务共用一个事务，小事务按照大事务的设置项来,小事务自己的设置失效
    public void updateBalanceByUsername(String username, BigDecimal delta) throws InterruptedException {
        String sql = "update account set balance = balance - ? where username = ?";
        Thread.sleep(4000);
        jdbcTemplate.update(sql, delta, username);
    }



}
