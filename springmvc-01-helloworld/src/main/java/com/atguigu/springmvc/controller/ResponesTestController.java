package com.atguigu.springmvc.controller;

import ch.qos.logback.classic.pattern.RelativeTimeConverter;
import com.atguigu.springmvc.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * ClassName: ResponesTestController
 * Package: com.atguigu.springmvc.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/4/29 10:31
 * @Version 19
 */
// @RestController是@Controller和@ResponseBody
//@ResponseBody注解通常用来将方法返回的对象值直接写入HTTP响应体，而不是跳转视图
@RestController
public class ResponesTestController {

    /**
     * 会自动的把返回的对象转为json的数据类型
     * @return
     */
    @ResponseBody // 把返回的内容。写到响应体中
    @RequestMapping(value = "/resp01",produces = MediaType.APPLICATION_JSON_VALUE)
    public Person resp01() {
        Person person = new Person();
        person.setUsername("zhangsan");
        person.setPassword("111111");
        person.setCellphone("222222");
        person.setAgreement(false);
        person.setSex("男");
        person.setHobby(new String[]{"足球","篮球"});
        person.setGrade("二年级");
        return person;
    }

    /**
     * 文件下载
     *      HttpEntity：拿到整个请求数据
     *      ResponseEntity:拿到整个响应数据(响应头、响应体、状态码)
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        // 文件下载的模板，定死了的，你可以改地址参数
        // 以上代码永远别改

        FileInputStream inputStream = new FileInputStream("C:\\Users\\ywh999\\Desktop\\1.jpg");

        // 一次性读会溢出
        // byte[] bytes = inputStream.readAllBytes();

        // 1、文件名中文会乱码
        String encode = URLEncoder.encode("猫.jpg","UTF-8");

        //以下代码永远别改
        // 2、文件太大会oom(内存溢出)


        InputStreamResource resource = new InputStreamResource(inputStream);

        return ResponseEntity.ok()
                // 内容类型：流
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                // 内容大小
                .contentLength(inputStream.available())
                // Content-Disposition : 内容处理方式
                .header("Content-Disposition", "attachment; filename=" + encode)
                .body(resource);


    }

}
