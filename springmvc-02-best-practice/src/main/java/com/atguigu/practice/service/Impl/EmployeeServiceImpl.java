package com.atguigu.practice.service.Impl;

import com.atguigu.practice.bean.Employee;
import com.atguigu.practice.exception.BizException;
import com.atguigu.practice.exception.BizExceptionEnume;
import com.atguigu.practice.service.EmployeeService;
import com.atguigu.practice.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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


    /**
     * 大型系统出现以下异常
     *
     */
    @Override
    public void updateEmp(Employee employee) {
        //防空处理。考虑到service是被controller调用的
        //controller层传过来的employee的某些属性可能为null，所以先处理一下
        //怎么处理？
        Long id = employee.getId();
        if(id == null) { //页面没有带id
            // 中断的业务的时候，必须让上层及以上的链路知道中断原因。推荐抛出业务异常
            throw new BizException(BizExceptionEnume.ORDER_CLOSED);
        }

        //1、去数据库查询employee原来的值
        Employee empById = employeeDao.getEmpById(id);

        //2、把页面带来的覆盖原来的值，页面没带的自然保持原来的值
        if(StringUtils.hasText(employee.getName())) {// 记得去看看这个hasText方法，写得很好！如果empById中的相关属性是null,空串，空白字符则它继续保持原来的null,空串，空白字符
            empById.setName(employee.getName());
        }

        if(StringUtils.hasText(employee.getEmail())) {
            empById.setAge(employee.getAge());
        }

        if(StringUtils.hasText(employee.getGender())) {
            empById.setGender(employee.getGender());
        }

        if(StringUtils.hasText(employee.getAddress())) {
            empById.setAddress(employee.getAddress());
        }

        if(employee.getAge() != null) {
            empById.setAge(employee.getAge());
        }

        if(employee.getSalary() != null) {
            empById.setSalary(employee.getSalary());
        }

        // 以上判断把页面提交的值，赋值给数据库的记录

        employeeDao.updateEmp(empById);

    }

    @Override
    public void deleteEmp(Long id) {
        employeeDao.deleteEmp(id);
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeDao.getAllEmp();
    }
}
