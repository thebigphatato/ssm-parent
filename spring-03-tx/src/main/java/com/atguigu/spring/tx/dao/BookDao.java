package com.atguigu.spring.tx.dao;

import com.atguigu.spring.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBookStock(Integer id,Integer num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql,num,id);
        int i = 10/0;//炸的放在这看看
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
    @Transactional
    public Book getBookById(Integer id) {

        //1、查询图书SQL
        String sql = "select * from book where id = ?";// ?是一个占位符
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        // BeanPropertyRowMapper<>(xxx.class) 将Bean的属性和数据库的行中的字段一一映射起来。
        // 后面参数的位置的内容就对应问号占位符的内容

        return book;
    }


    // REPEATABLE_READ:可重复读。快照读。MySQL默认
    // READ_COMMITTED:读已提交。当前读。Oracle默认
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public BigDecimal getBookPrice(Integer id) {
        String sql = "select price from book where id = ?";
        BigDecimal decimal1 = jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
        BigDecimal decimal2 = jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
        BigDecimal decimal3 = jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
        BigDecimal decimal4 = jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
        BigDecimal decimal5 = jdbcTemplate.queryForObject(sql,BigDecimal.class,id);
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
    }


}
