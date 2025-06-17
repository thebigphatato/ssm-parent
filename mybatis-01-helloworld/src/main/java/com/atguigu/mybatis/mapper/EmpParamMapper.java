package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ClassName: EmpParamMapper
 * Package: com.atguigu.mybatis.dao
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/16 19:02
 * @Version 19
 */

// 单个参数情况时：
// 1、#{参数名} 就可以取到值，
// 2、但是Map和JavaBean除外， #{key/属性名}可以取值

@Mapper
public interface EmpParamMapper {

    Emp getEmpoly(Long id);

    //获取数组中第二个元素指定的用户
    Emp getEmploy02(List<Long> ids);

    // 单参数情况时，对于Bean和Map来说，对象属性取值，直接获取，不用对象名称.属性值
     void addEmploy(Emp emp);

    // map中的属性也是直接取值
    void addEmploy02(Map<String, Object> m);


    // 以上时单个参数测试的情况，下面是多个参数测试的情况

    // 以后多个参数，用@Param("") 指定参数名，#{}就可以取值了
    Emp getEmployByIdAndName(@Param("id") Long id, @Param("empName") String name);


    // 现在的要求是：
    // select * from t_emp where
    // id = #{id} and emp_name = #{从map中取到的name} and age = #{ids的第三个参数值}
    // and salary = #{e中的salary}
    // 首先为每个参数用@Param指定参数名
    // 光标放在方法名那，alt+enter后 找一个 [MybatisX] Generate @Param的选项
    Emp getEmployHaha(@Param("id") Long id,
                      @Param("m") Map<String, Object> m,
                      @Param("ids") List<Long> ids,
                      @Param("e") Emp e);



}
