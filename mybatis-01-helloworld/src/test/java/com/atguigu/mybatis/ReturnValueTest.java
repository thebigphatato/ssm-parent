package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpReturnValueMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ReturnValueTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 11:13
 * @Version 19
 */
@SpringBootTest
public class ReturnValueTest {

    @Autowired
    EmpReturnValueMapper empReturnValueMapper;

    @Test
    void test02() {
        Emp empById = empReturnValueMapper.getEmpById(1);
        System.out.println("empById=" + empById);
    }

    @Test
    void test01() {
        Long l = empReturnValueMapper.countEmp();
        System.out.println(l);

        BigDecimal bigDecimal = empReturnValueMapper.getEmpSalaryById(1);
        System.out.println(bigDecimal);

        empReturnValueMapper.getAll().forEach(System.out::println);
//        for (Emp emp : list) {
//            System.out.println(emp);
//        }
        Map<Integer, Emp>  allMap = empReturnValueMapper.getAllMap();
        System.out.println("allMap:" + allMap);

        System.out.println(allMap.get(1).getClass());
        Emp emp = allMap.get(3);
        System.out.println(emp.getClass());
        System.out.println(emp.getAge());



    }


}
