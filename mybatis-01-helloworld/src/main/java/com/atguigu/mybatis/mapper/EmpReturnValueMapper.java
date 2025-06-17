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

//
// 返回值结果：
//     返回对象，普通类型：resultType="全类名"
//     返回集合：        resultType="集合中元素全类名"
//

@Mapper
public interface EmpReturnValueMapper {

    Long countEmp();

    BigDecimal getEmpSalaryById(Integer id);

    List<Emp> getAll();


    @MapKey("id") // 实际保存的不是Emp, 是HashMap
    Map<Integer,Emp>getAllMap();

}
