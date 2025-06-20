package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: CustomerDynamicSQLMapper
 * Package: com.atguigu.mybatis.mapper
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/19 15:53
 * @Version 19
 */

@Mapper
public interface EmpDynamicSQLMapper {

    //1、按照 empName 和 empSalary 查询员工
    List<Emp> queryEmpByNameAndSalary(@Param("name") String name,
                                       @Param("salary") BigDecimal salary);


}
