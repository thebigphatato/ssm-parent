package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

@SpringBootTest
class Mybatis01HellowordApplicationTests {

    @Autowired //容器中是MyBatis为每个Mapper接口创建的代理对象
    EmpMapper empMapper;

    @Test
    void testValue() {
        //前端传来的参数最好做一个校验（SQL防注入校验） or
        //SQL防注入工具类
        Emp tEmp = empMapper.getEmpById02(1,"t_emp");
        System.out.println("tEmp = " + tEmp);
    }


    @Test
    void testAll() {
        List<Emp> emps = empMapper.getAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }

    }


    @Test
    void testCRUD() {
        Emp emp = new Emp();
        emp.setEmpName("张三");
        emp.setAge(17);
        emp.setEmpSalary(1000D);

        // 添加是id自增
        empMapper.addEmp(emp);

        Integer id = emp.getId();
        System.out.println("上次自增id = " + id);
    }

    @Test
    void testCRUD_2() {
        Emp emp = new Emp();
        emp.setId(5);
        emp.setEmpName("张三");
        emp.setAge(10);
        emp.setEmpSalary(1000D);
        empMapper.updateEmp(emp);
    }


    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("empMapper = " + empMapper.getClass());

        // #{} 这是sql语句里面是井号+大括号的取值 （预编译方式）
        // Preparing: select id,emp_name empName,age,emp_salary empSalary from t_emp where id = ?;
        // Parameters: 1(Integer)
        // Total: 1

        // ${}取值：是直接把参数的值拼到sql语句上 （拼接方式）
        // Preparing: select id,emp_name empName,age,emp_salary empSalary from t_emp where id = 1;
        //  Parameters:
        //  Total: 1

        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);

//        Connection connection = dataSource.getConnection();
//
//        String sql1 = "select * from t_emp where username = ? and password = ?";
//        // 预编译方式 这就是类似于#{}的底层代码
//        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
//        preparedStatement.setString(1,"admin");
//        preparedStatement.setString(2,"123456");
//
//        // ${}底层 拼接方式： 有可能会引发SQL注入问题
//        String sql2 = "select * from t_emp where username = 'admin' and password = '' or 1=1 or 1='' ";
//        Statement statement =connection.createStatement();
//        statement.execute("select * from t_emp where id = " + 2);


    }

}
