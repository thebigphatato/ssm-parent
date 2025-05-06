package com.atguigu.rest.crud.dao;

import com.atguigu.rest.crud.bean.Employee;
import org.springframework.stereotype.Component;

/**
 * ClassName: EmployeeDao
 * Package: com.atguigu.rest.crud.dao
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 15:54
 * @Version 19
 */

public interface EmployeeDao {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    Employee getEmpById(Long id);

    /**
     * 新增员工
     * @param employee
     */
    void addEmp(Employee employee);

    /**
     * 修改员工
     * @param employee
     */
    void updateEmp(Employee employee);

    /**
     * 按照id删除员工
     * @param id
     */
    void deleteEmp(Long id);
}
