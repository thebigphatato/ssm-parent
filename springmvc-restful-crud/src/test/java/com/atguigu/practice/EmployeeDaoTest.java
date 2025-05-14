package com.atguigu.practice;

import com.atguigu.practice.bean.Employee;
import com.atguigu.practice.dao.EmployeeDao;
import com.atguigu.practice.service.EmployeeService;
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

    @Autowired
    EmployeeService employeeService;

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

    @Test
    void testEmployeeService() {
        System.out.println("EmployeeServiceTest");
        Employee employee1 = new Employee();
        employee1.setId(4l);
        employee1.setName("李四22");
        employee1.setAge(10);
        employee1.setEmail("aaa");
        employee1.setAddress("武汉");
        employee1.setGender("男");
        employee1.setSalary(new BigDecimal("1.1"));

        employeeService.updateEmp(employee1);

    }

}
