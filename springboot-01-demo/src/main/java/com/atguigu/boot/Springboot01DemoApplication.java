package com.atguigu.boot;

import com.atguigu.boot.properties.DogProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.swing.*;

/**
 * 在maven里面按ctrl选中clean和package。然后选择toggle skip test mode 这样会加速
 * 然后在target里会找到相应的jar文件包
 * 再然后在服务器里面就可以运行 java -jar app.jar就可以运行了，这一步就是把项目应用部署在服务器上了
 */


@EnableConfigurationProperties(DogProperties.class ) // 他会把这个类放进容器中，并一一将配置文件的属性与属性类中的属性绑定
//自动配置
@SpringBootApplication
public class Springboot01DemoApplication {

    // 1、以前：war包； webapps目录下
    public static void main(String[] args) {
        //应用启动
//        SpringApplication.run(Springboot01DemoApplication.class, args);


        // 第二种启动应用的方式：链式调用启动项目
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.sources(Springboot01DemoApplication.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .environment(null)
////                .listeners(null)
//                .run(args);

        // 1、创建SpringApplication对象
        SpringApplication application = new SpringApplication(Springboot01DemoApplication.class);

//        application.setBannerMode(Banner.Mode.OFF); //关闭banner
//        application.setListeners(); // 设置监听器
//        application.setEnvironment(); // 设置环境变量
//        application.setBanner(); // 设置banner

        // 2、启动
        application.run(args);
    }

}
