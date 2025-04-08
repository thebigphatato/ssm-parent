package com.atguigu.spring.tx.dao;

import com.atguigu.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author thebigpotato
 * @create 2025-04-03-22:54
 */
@Component
public class BookDao {


    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * 按照id查询图书
     * @param id
     * @return
     */
    public Book getBookByid(Integer id) {

        //1、查询图书SQL
        String sql = "select * from book where id = ?";// ?是一个占位符
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);

        return book;
    }
}
