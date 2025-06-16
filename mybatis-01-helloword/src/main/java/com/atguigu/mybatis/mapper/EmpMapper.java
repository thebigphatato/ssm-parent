package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author thebigpotato
 * @create 2025-05-21-14:39
 */

@Mapper //告诉spring，这是MyBatis操作数据库用的接口；Mapper接口
public interface EmpMapper { //alt + enter 在类名旁边使用这个大括号，可以生成mapper的xml文件

    Emp getEmpById02(Integer id,String tableName);

    //按照id查询
    Emp getEmpById(Integer id);

    //查询所有员工
    List<Emp> getAll();

    //添加员工
    void addEmp(Emp emp);

    //更新员工
    void updateEmp(Emp emp);

    //按照id删除员工
    void deleteEmpById(Integer id);
}
