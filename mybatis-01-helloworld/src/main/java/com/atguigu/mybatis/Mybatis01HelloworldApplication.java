package com.atguigu.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 步骤：
 * 1、导入mybatis依赖
 * 2、配置数据源信息
 * 3、编写一个JavaBean对应数据库一个表模型
 * 4、以前: Dao接口 --> Dao实现 --> 标注 @Repository注解
 *    现在: Mapper接口 --> Mapper.xml实现;  --> 标注 @Mapper注解
 *      安装mybatisx插件，自动为 mapper类生成 mapper文件 快捷键：alt+enter
 *      在mapper文件中配置方法的实现sql
 * 5、告诉MyBatis去哪里找Mapper文件；mybatis.mapper-locations=classpath:mapper/**.xml
 * 6、编写单元测试
 *
 *
 * mybatis逆向生成：
 * 1、在数据库中建好表格后，点击右侧栏中的数据库，点击+号
 * 2、或者在application.properties里面选中跟数据库相关的那几行，点击左边的+号
 * 3、数据库添加好以后，在右侧栏的数据库中，按ctrl选中相应的表，再按右键选择 “MybatisX-Generator”
 * 4、进入之后配置好module path
 * 5、其中relative package中的domain就是指javaBean的意思
 * 6、然后base package就是指本模块中的com.atguigu.mybatis ，填好之后，点击next
 * 7、选中Lombok和 template中的default-all,这就会生成xml和mapper然后就finish了
 *
 *
 *
 *
 */
@EnableTransactionManagement
@SpringBootApplication
public class Mybatis01HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis01HelloworldApplication.class, args);
	}

}
