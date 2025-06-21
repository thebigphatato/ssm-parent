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
 *
 * 按 Tab → 选中的代码集体向右缩进​
 * 按 Shift + Tab → 选中的代码集体向左移动
 * 上下移动选中行：
 * Windows/Linux: Alt + Shift + ↑/↓
 */

@Mapper
public interface EmpDynamicSQLMapper {

    //1、按照 empName 和 empSalary 查询员工
    List<Emp> queryEmpByNameAndSalary(@Param("name") String name,
                                       @Param("salary") BigDecimal salary);

    void updateEmp(Emp emp);

    // trim:字符串截串、去空白


    List<Emp> queryEmpByNameAndSalaryWhen(@Param("name") String name,
                                      @Param("salary") BigDecimal salary);

    // 查询指定id集合中的员工集合
    List<Emp> getEmpsByIdIn(List<Integer> ids);

    // 批量插入一些员工
    void addEmps(List<Emp> emps);

    // 批量跟新一些员工
    void updateBatchEmp(List<Emp> emps);


}
