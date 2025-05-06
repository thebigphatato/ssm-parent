package com.atguigu.rest.crud;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: EmployeeDaoTest
 * Package: com.atguigu.rest.crud
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 16:18
 * @Version 19
 */
@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void testEmployeeDao() {
        System.out.println("EmployeeDaoTest");
//        Employee employee = employeeDao.getEmpById(4l);
//        System.out.println("employee = " + employee);

//        Employee employee1 = new Employee();
//        employee1.setName("李四");
//        employee1.setAge(10);
//        employee1.setEmail("aaa");
//        employee1.setAddress("武汉");
//        employee1.setGender("男");
//        employee1.setSalary(new BigDecimal("0"));
        employeeDao.deleteEmp(5l);


    }

}
