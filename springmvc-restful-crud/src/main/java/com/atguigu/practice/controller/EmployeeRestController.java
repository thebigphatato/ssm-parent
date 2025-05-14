package com.atguigu.practice.controller;

import com.atguigu.practice.bean.Employee;
import com.atguigu.practice.common.R;
import com.atguigu.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CORS policy：同源策略（限制ajax请求，图片，css,js）；跨域问题
 * 跨源资源共享(CORS) (Cross-origin Resource Sharing)
 *      浏览器为了安全，默认会遵循同源策略(请求要去的服务器和当前项目所在的服务器是同一个源[同一个服务器])，如果不是。请求就会被拦截
 *      复杂的跨域请求会发送2次；
 *      1、options请求：预检请求。浏览器会先发送options请求，询问服务器是否允许当前域名进行跨域访问。
 *      2、真正的请求：POST,PUT,DELETE,GET等
 * 浏览器页面所在地址：http://localhost/
 * 页面上要发的请求地址：http://localhost:8080/api/v1/employees
 *      斜杠/前面的东西，必须完全一样，一个字母不一样都不行。浏览器才能把请求（ajax）发出去
 *
 * 跨越问题：
 *  1、前端自己解决：
 *  2、后端解决：允许前端跨域即可
 *      原理：服务器给浏览器的响应头添加字段：Access-Control-Allow-Origin = *
 *
 *
 */

/**
 * ClassName: EmployeeRestController
 * Package: com.atguigu.rest.crud.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/7 9:52
 * @Version 19
 */
@CrossOrigin // 允许跨域
@RequestMapping("/api/v1")
@RestController// RestController = controller + responseBody(把对象写成json格式)
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * code : 业务的状态码，200是成功，剩下的都是失败的状态码;前后端将来会一定商定不同的业务状态码，前端要显示不同效果。
     * message : 服务端返回给前端的提示信息
     * data : 服务器返回给前端的数据
     * {
     *     "code" : 200,
     *     "message" : "......",
     *     "data" : null
     * }
     *
     * 前端统一处理：
     *      1、前端发送请求，接受服务器数据
     *      2、判断状态码，成功就显示数据，失败就显示提示信息。(或者执行其他操作)
     */

    /**
     * 按照id查询员工
     * @param id
     * @return
     */
//    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    @GetMapping("/employee/{id}")
    public R get(@PathVariable("id") Long id) {
        Employee emp = employeeService.getEmpById(id);
        return  R.ok(emp);
    }

    /**
     * @XxxMapping()：Rest映射规则
     * @param id
     * @return
     */

    @DeleteMapping(value = "/employee/{id}")
    public R delete(@PathVariable("id") Long id) {
        employeeService.deleteEmp(id);
        return R.ok();
    }

    /**
     * 新增员工
     * 要求：前端发送请求把员工的json发在请求体中
     * @param emp
     * @return
     */
    @PostMapping("/employee")
    public R add(@RequestBody Employee emp) {
        employeeService.addEmp(emp);
        return R.ok();
    }

    /**
     * 修改员工
     * 要求：前端发送请求把员工的json发在请求体中
     * @param emp
     * @return
     */
    @PutMapping("/employee")
    public R update(@RequestBody Employee emp) {
        employeeService.updateEmp(emp);
        return R.ok();
    }

    //语义化
    @GetMapping("/employees")
    public R all() {
        List<Employee> employees =  employeeService.getAllEmp();
        return R.ok(employees);

    }
}
