package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsNotFoundException;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@SpringBootTest
class Mybatis01HelloworldApplicationTests {

	@Autowired  //容器中是MyBatis为每个Mapper接口创建的代理对象
	EmpMapper empMapper;

	@Test
	void testValue() {
		// 前端传来的参数最好做一个校验 (SQL防注入校验)  用正则表达式来做
		// 有很多SQL防注入工具类，不用自己写，这个地方去问AI
		Emp tEmp = empMapper.getEmpById02(1,"t_emp");
		System.out.println("tEmp = " + tEmp);
	}


	@Test
	void testAll() {
		List<Emp> emps = empMapper.getAll();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}




	@Test
	void testCRUD() {
		Emp emp = new Emp();
		emp.setId(7);
		emp.setAge(10);
		emp.setEmpName("王五");
		emp.setEmpSalary(1000.0D);

//		empMapper.addEmp(emp);
//		empMapper.updateEmp(emp);
//		empMapper.deleteEmpById(7);

		// 添加是id自增
		empMapper.addEmp(emp);

		Integer id = emp.getId();
		System.out.println("上次自增id =  " + id);

	}

	@Autowired
	DataSource datasource;

	@Test
	void contextLoads() throws SQLException {
		System.out.println("empMapper = " + empMapper.getClass());

		// #{}：预编译的方式  用这中方式取值时的日志
//		Preparing: select id,emp_name empName,age,emp_salary empSalary from t_emp where id = ?
//		Parameters: 1(Integer)
//		Total: 1

//		  ${}：拼接方式 用这种方式取值时
//		Preparing: select id,emp_name empName,age,emp_salary empSalary from t_emp where id = 1
//		Parameters:
//		Total: 1
		Emp empById = empMapper.getEmpById(1);
		System.out.println("empById = " + empById);

//		Connection connection = datasource.getConnection();
//
//		// #{}底层：预编译的方式
//		String sql = "select * from emp user where username = ? and password = ?";
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		preparedStatement.setString(1, "admin");
//		preparedStatement.setString(2, "123456");
//
//
//		// ${}底层拼接方式： :SQL注入问题
//		String sql2 = "select * from emp user where username = 'admin' and password = '' or 1=1 or 1='' ";
//		Statement statement = connection.createStatement();
//		statement.execute("select * from t_emp where id = " + 2);



	}

}
