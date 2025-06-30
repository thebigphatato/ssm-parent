package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: PageTest
 * Package: com.atguigu.mybatis
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/26 20:48
 * @Version 19
 */

@SpringBootTest
public class PageTest {
    @Autowired
    EmpService empService;

    @Test
    void test02() {

        // 后端收到前端传来的页码

        //前端需要的数据
        // 1、总页码、总记录数
        // 2、当前页码
        // 3、本页数据
        PageHelper.startPage(1, 5);
        List<Emp> all = empService.getAll();

        System.out.println("==========================");
        PageInfo<Emp> pageInfo = new PageInfo<>(all);

        //  当前第几页
        System.out.println("当前页码：" + pageInfo.getPageNum());
        // 总页码
        System.out.println("总页码：" + pageInfo.getPages());
        // 总记录
        System.out.println("总记录数：" + pageInfo.getPageNum());
        // 有没有下一页
        System.out.println("有没有下一页：" + pageInfo.isHasNextPage());
        // 有没有上一页
        System.out.println("有没有上一页：" + pageInfo.isHasPreviousPage());
        // 本页数据
        System.out.println("本页数据：" + pageInfo.getList());



    }


    @Test
    void test01() {

        /**
         * 原理：拦截器；
         * 原业务底层： select * from emp;
         * 拦截做两件事：
         * 1）、统计这个表的总数量
         * 2）、给原业务底层SQL动态拼接上 limit 0,5;
         *
         * ThreadLocal：同一个线程共享数据
         *      1、第一个查询从ThreadLocal中获取共享数据，执行分页
         *      2、第一个执行完会把ThreadLocal分页删除数据
         *      3、以后的查询，从ThreadLocal 中拿不到分页数据，就不会分页
         *
         */

        PageHelper.startPage(1, 5);
        // 紧跟着 startPage之后的方法就会执行 SQL 分页查询
        // 后面的第二个方法就不会分页了
        List<Emp> all = empService.getAll();
        for(Emp emp : all){
            System.out.println(emp);
        }

        System.out.println("========================");
        List<Emp> all1 = empService.getAll();
        System.out.println(all1.size());

    }


}
