package com.atguigu.practice.service;

import com.atguigu.practice.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: EmployeeService
 * Package: com.atguigu.rest.crud.service
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 15:57
 * @Version 19
 */
@Service
public interface EmployeeService {

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

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getAllEmp();
}
