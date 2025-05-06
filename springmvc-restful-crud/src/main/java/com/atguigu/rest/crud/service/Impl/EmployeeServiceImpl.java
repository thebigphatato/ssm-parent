package com.atguigu.rest.crud.service.Impl;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import com.atguigu.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * ClassName: EmployeeServiceImpl
 * Package: com.atguigu.rest.crud.service.Impl
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/6 15:58
 * @Version 19
 */
@Service // 要求：controller层只能调用service，不能调用dao，service可以调dao和同层的、
         // 调用规则是：上可以调下，下不能调用上，可以调同层，但不能跨层
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao; //包装一下

    @Override
    public Employee getEmpById(Long id) {
        return employeeDao.getEmpById(id);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }

    @Override
    public void updateEmp(Employee employee) {
        //防空处理。考虑到service是被controller调用的
        //controller层传过来的employee的某些属性可能为null，所以先处理一下
        //怎么处理？
        Long id = employee.getId();
        if(id == null) { //页面没有带id
            return;
        }

        //1、去数据库查询employee原来的值
        Employee empById = employeeDao.getEmpById(id);

        //2、把页面带来的覆盖原来的值，页面没带的自然保持原来的值
        if(StringUtils.hasText(empById.getName())) {// 记得去看看这个hasText方法，写得很好！
            empById.setName(employee.getName());
        }


        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmp(Long id) {
        employeeDao.deleteEmp(id);
    }
}
