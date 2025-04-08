package com.atguigu.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
    public void updateBalanceByUsername(String username, BigDecimal delta) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, delta, username);
    }



}
