package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ParamTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 9:35
 * @Version 19
 */

@SpringBootTest
public class ParamTest {

    @Autowired
    EmpParamMapper empParamMapper;

    @Test
    void testParam1() {
        Emp employe = empParamMapper.getEmpoly(1l);
    }

    @Test
    void testParam2() {
        Emp employe = empParamMapper.getEmploy02(Arrays.asList(1L,2L,3L,4L));
    }

    @Test
    void testParam03() {
        Emp emp = new Emp();
        emp.setId(5);
        emp.setEmpName("feijun");
        emp.setAge(24);
        emp.setEmpSalary(10000.0D);
        empParamMapper.addEmploy(emp);
    }

    @Test
    void testParam04() {

        Map<String, Object> params = new HashMap<>();
        params.put("id", "6");
        params.put("empName", "bbbb");
        params.put("age", 24);
        params.put("empSalary", 10000.0D);

        empParamMapper.addEmploy02(params);

    }



    // 以上是单个参数测试的情况，下面是多个参数测试的情况

    @Test
    void testParam05() {
       Emp zhangsan = empParamMapper.getEmployByIdAndName(1l,"tom");

    }

    @Test
    void testParam06() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "asdasd");
        Emp emp = new Emp();
        emp.setEmpSalary(10000.0D);


        empParamMapper.getEmployHaha(
                1l,
                params,
                Arrays.asList(19l,20l,21l,22l,34l),
                emp);

    }



}
