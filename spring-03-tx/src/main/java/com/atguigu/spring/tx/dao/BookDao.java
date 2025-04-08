package com.atguigu.spring.tx.dao;

import com.atguigu.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author thebigpotato
 * @create 2025-04-03-22:54
 */


/**
 * DAO: Data Access Object数据访问对象，用于实现数据访问层的代码结构和功能的，主要目的是将数据访问逻辑和业务逻辑分离，
 * 提尕代码的可维护性、可测试性、可扩展性。
 */
@Component
public class BookDao {


    @Autowired
    JdbcTemplate jdbcTemplate;





    /**
     * 按照id删除图书
     * @param id
     */
    public void deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql,id);
    }



    /**
     * 按照id修改图书库存
     * @param id
     * @param num
     */
    public void updateBookStock(Integer id,Integer num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql,num,id);
    }

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book) {
        String sql = "insert into book(bookName,price,stock) values(?,?,?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /**
     * 按照id查询图书
     * @param id
     * @return
     */
    public Book getBookById(Integer id) {

        //1、查询图书SQL
        String sql = "select * from book where id = ?";// ?是一个占位符
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        // BeanPropertyRowMapper<>(xxx.class) 将Bean的属性和数据库的行中的字段一一映射起来。
        // 后面参数的位置的内容就对应问号占位符的内容

        return book;
    }


}
