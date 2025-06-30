package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpDynamicSQLMapper;
import com.atguigu.mybatis.service.EmpService;
import org.apache.ibatis.jdbc.AbstractSQL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: DynamicSQLTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/19 16:00
 * @Version 19
 */

/**
 * trim 可以 实现 set 去掉多余逗号，where 去掉多余and/or 的功能
 * choose/when/otherwise标签,在多个分支条件中，仅执行一个.
 * foreach标签用来遍历，循环；常用于批量插入场景；批量单个SQL
 */
@SpringBootTest
public class DynamicSQLTest {

    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;

    @Autowired
    EmpService empService;

    @Test
    void test09() {
        empDynamicSQLMapper.getEmpsByIdIn(Arrays.asList(1,2,3));
    }

    // 分布式项目情况下，分布式事务很多不支持多SQL批量操作的回滚
    @Test
    void test08() {
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Emp emp = new Emp();
            emp.setId(226+i);
            emp.setEmpName("张-"+100+i);
            emp.setAge(100+i);
            emp.setEmpSalary(90000.0D+i);
            emps.add(emp);
        }
        empService.updateBatch(emps);
        System.out.println("批量更新完成");
    }


    // test05-07都是讲foreach标签
//    @Test
//    void test07(){
//        for (int i = 0; i < 100; i++) {
//            empDynamicSQLMapper.updateEmp(new Emp());
//        }
//
//    }

    //一口气发一堆SQL效率最高。但要主要有事务问题，这个比test07的效率高
    @Test
    void test06(){
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Emp emp = new Emp();
            emp.setId(10+i);
            emp.setEmpName("张-"+100+i);
            emp.setAge(100+i);
            emp.setEmpSalary(70000.0D+i);
            emps.add(emp);
        }



        /**
         * update t_emp SET emp_name = ?, emp_salary = ?, age = ? where id=? ;
         * update t_emp SET emp_name = ?, emp_salary = ?, age = ? where id=? ;
         * update t_emp SET emp_name = ?, emp_salary = ?, age = ? where id=? ;
         * update t_emp SET emp_name = ?, emp_salary = ?, age = ? where id=? ;
         */

        empDynamicSQLMapper.updateBatchEmp(emps);
    }

//    @Test
//    void test051(){
//        List<Emp> emps = new ArrayList<>();
//        for (int i = 0; i < 1; i++) {
//            Emp emp = new Emp();
//            emp.setAge(i);
//            emp.setEmpSalary(0.000D);
//            emp.setEmpName("zs");
//            emps.add(emp);
//        }
//        empDynamicSQLMapper.addEmps(emps);
//    }

    @Test
    void test05(){
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Emp emp = new Emp();
            emp.setEmpName("张-"+i);
            emp.setAge(20+i);
            emp.setEmpSalary(10000.0D+i);
            emps.add(emp);
        }

        //批量插入  values (?, ?, ?), (?, ?, ?)
        empDynamicSQLMapper.addEmps(emps);
    }




    // test04主要是讲述foreach标签
    @Test
    void test04() {
//        List<Emp> idIn = empDynamicSQLMapper.getEmpsByIdIn(Arrays.asList(1,3,4,7,9));
//        哪怕有idIn这个对象，但是这个对象里面是null，但是foreach还是会开始迭代
        List<Emp> idIn = empDynamicSQLMapper.getEmpsByIdIn(null);
        for (Emp emp : idIn) {
            System.out.println(emp);
        }
    }

    // test03主要是讲述choose标签，when标签，otherwise标签
    @Test
    void test03() {
        empDynamicSQLMapper.queryEmpByNameAndSalaryWhen("aaa",new BigDecimal(430000.00));
    }

    // test02主要是讲述set标签和trim标签
    @Test
    void test02() {
        Emp emp = new Emp(); // Alt + Insert快速生成get set 构造器等
        emp.setId(7);
        emp.setEmpName("哈哈222");
//        emp.setAge(18);
//        emp.setEmpSalary(10.0D);

        // 带了哪个只更新哪个，没带的就用原值
        empDynamicSQLMapper.updateEmp(emp);
    }

    // test01主要是讲述where标签
    @Test
    void test01() {

//        empDynamicSQLMapper.queryEmpByNameAndSalary("a",null);

//        select * from t_emp where and emp_salary = ?;当用下面的方法时,mybatis生成的SQL语句如左边所示
        empDynamicSQLMapper.queryEmpByNameAndSalary(null,new BigDecimal(35000.00));

//        select * from t_emp where
//        empDynamicSQLMapper.queryEmpByNameAndSalary(null,null);

    }
}
