package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpDynamicSQLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: DynamicSQLTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/19 16:00
 * @Version 19
 */
@SpringBootTest
public class DynamicSQLTest {
    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;

    @Test
    void test01() {

//        empDynamicSQLMapper.queryEmpByNameAndSalary("a",null);

//        select * from t_emp where and emp_salary = ?;当用下面的方法时,mybatis生成的SQL语句如左边所示
//        empDynamicSQLMapper.queryEmpByNameAndSalary(null,new BigDecimal(35000.00));

//        select * from t_emp where
        empDynamicSQLMapper.queryEmpByNameAndSalary(null,null);

    }
}
