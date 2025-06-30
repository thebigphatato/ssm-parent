package com.atguigu.mybatis.service;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpDynamicSQLMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: EmpService
 * Package: com.atguigu.mybatis.service
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/24 13:51
 * @Version 19
 */

/**
 * 一级缓存：默认事务期间，会开启事务级别缓存；
 * 1、同一个事务期间，前面查询的数据，后面如果再要执行相同查询，会从一级缓存中获取数据，不会给数据库发送SQL
 *
 * 二级缓存：
 *
 * 多级缓存机制？
 *
 * 一级缓存默认开启；事务级别：当前事务共享
 * 二级缓存需要手动配置开启；所有事务共享
 * 缓存中有就不需要查数据库
 *
 */

@Service
public class EmpService {

    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;

    @Autowired
    EmpMapper empMapper;

    public List<Emp> getAll() {
        return empMapper.getAll();
    }


    @Transactional //默认 可重复读
    public void find() {
        Emp empById = empMapper.getEmpById(1);
        System.out.println("员工：" + empById);

        System.out.println("=======================");

        empMapper.deleteEmpById(7);
        // 有时候缓存会失效(缓存不命中)。
        // 失效几种情况
        // 1、查询的东西不一样
        // 2、两次查询之间，进行了一次增删改（由于增删改会引起数据库变化，Mybatis认为，数据有可能变了，它就要再发一次查询）

        Emp emp = empMapper.getEmpById(1);
        System.out.println("员工：" + empById);

        System.out.println("=======================");


    }

    @Transactional
    public void updateBatch(List<Emp> emps) {
//        empDynamicSQLMapper.updateBatchEmp(emps);
//        int i = 10/0;

        Emp empById = empMapper.getEmpById(1);
        System.out.println("员工：" + empById);

        System.out.println("=======================");

        Emp emp = empMapper.getEmpById(1);
        System.out.println("员工：" + empById);

        System.out.println("=======================");


    }
}
