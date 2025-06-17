package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * ClassName: EmpReturnValueMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/17 11:08
 * @Version 19
 */

/**
 *  返回值结果：
 *      返回对象，普通类型：resultType="全类名"
 *      返回集合：        resultType="集合中元素全类名"
 *
 *  最佳实践：
 *      1、开启驼峰命名
 *      2、驼峰命名搞不定的，用自定义映射
 */

/**
 * 和数据库对不上的字段封装为null
 * 如何解决？
 * 0、JavaBean 和 数据库 一一对应【不推荐】
 * 1、使用 列别名
 * 2、使用 驼峰命名自动映射
 * 3、使用ResultMap(自定义结果集)
 *
 * 数据关系：
 * 1对1：关联关系存到两方任意一方的表都可以
 * 1对多：关联关系存到“多”的一方所对应的表中
 * 多对多：需要一张中间表，关联关系存到这张中间表中
 *
 *
 * */

@Mapper
public interface EmpReturnValueMapper {

    Long countEmp();

    BigDecimal getEmpSalaryById(Integer id);

    List<Emp> getAll();


    @MapKey("id") // 实际保存的不是Emp, 是HashMap
    Map<Integer,Emp>getAllMap();

    Emp getEmpById(Integer id);



}
