package com.atguigu.spring.tx;


import com.atguigu.spring.tx.bean.Book;
import com.atguigu.spring.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;// 就是QueryRunner

    @Autowired
    BookDao bookDao;


    // HikariDataSource:这个数据源做增删改查快
    // DruidDataSource:这个数据源最广

    @Test
    void testQuery() {
        Book book = bookDao.getBookByid(1);
        System.out.println(book);
    }


    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());

//        jdbcTemplate.
    }

}
