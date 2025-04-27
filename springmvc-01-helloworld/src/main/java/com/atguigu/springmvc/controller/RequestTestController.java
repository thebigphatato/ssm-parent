package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author thebigpotato
 * @create 2025-04-26-19:31
 */

@RestController
public class RequestTestController {


    /**
     * 请求参数：username=ywh&password=123456&cellphone=313254165&agreement=on
     * 1、没有携带，包装类型自动封装为null，基本类型封装为默认值
     * 2、携带：自动封装
     * @RequestParam:取出某个参数的值，默认一定要携带。
     *      required = false;非必须携带，不携带参数默认值为false
     *      defaultValue = "123456";默认值：参数可以不带
     *
     * 无论请求参数带到了请求体中还是url?后面，他们都是请求参数。都可以直接用@RequestParam或者同一个 变量名获取到
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(String username,String password,String cellphone,boolean agreement) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "ok";
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password",defaultValue = "123456") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam(value = "agreement",required = false) boolean ok) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(phone);
        System.out.println(ok);
        return "ok";
    }


    // handle03把username=zhangsan&password=11111111&cellphone=13409798919&agreement=on
    // 一堆参数放在了请求体中，这就是Post和get的区别。

    /**
     * 如果目标方法参数是一个 pojo;SpringMVC会自动把请求参数和pojo属性进行匹配
     * pojo: plain old java object：普通Java对象
     * 效果：
     *      1、POJO的所有属性值都是来自于请求参数
     *      2、如果请求参数没和pojo中的属性对应上，则该值封装为null
     * @param person
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(Person person) {
        System.out.println(person);
        return "ok";
    }

    /**
     * 使用@RequestHeader来获取请求体的内容
     * @param host
     * @param useragent
     * @return
     */
    @RequestMapping("/handle04")
    public String handle04(@RequestHeader(value = "host") String host,
                           @RequestHeader("user-agent") String useragent) {
        System.out.println(host);
        System.out.println(useragent);
        return "ok~" + host;
    }

    /**
     * 使用@CookieValue来获取cookie的值，cookie是一堆键值对
     * @param haha
     * @return
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha") String haha) {

        return "ok:cookie是：" + haha;
    }

    /**
     * 使用pojo级联封装复杂属性
     * @param person
     * @return
     */
    @RequestMapping("/handle06")
    public String handle06(Person person) {
        System.out.println(person);
        return "ok";
    }

    /**
     * @RequestBody: 获取请求体json数据，自动转为person对象
     * 测试接受json数据
     * 1、发出：请求体中是json字符串，不是k=v
     * 2、接收：@RequestBody Person person
     * @RequestBody String json
     *      1、拿到请求体中的json字符串
     *      2、把json字符串转为person对象
     *
     * @param json
     * @return
     */
    @RequestMapping("/handle07")
    public String handle07(@RequestBody String json) throws JsonProcessingException {
        System.out.println(json);
        //自己把字符串转为对象。
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json,Person.class);
        System.out.println(person);
        return "ok";

        // 可以自动反序列化将json字符串转为person对象，只要在@RequestBody 后写Person person就可以了。
    }


    /**
     * 测试文件上传
     * 1、@RequestParam 取出文件项，封装为MultipartFile,就可以拿到文件内容
     * MultipartFile 专门封装文件项
     * @param person
     * @return
     */
    @RequestMapping("/handle08")
    public String handle08(Person person,
                           @RequestParam("headerImg") MultipartFile headerImgfile,
                           @RequestParam("lifeImg") MultipartFile[] lifeImgFiles) throws IOException {
        //1、获取原始文件名
        String originalFilename = headerImgfile.getOriginalFilename();
        //2、获取文件大小
        long size = headerImgfile.getSize();
        //3、获取文件流
        InputStream inputStream = headerImgfile.getInputStream();
        System.out.println(originalFilename + " ==> " + size);
        //4、文件保存
        headerImgfile.transferTo(new File("D:\\img\\" + originalFilename));

        System.out.println("============以上处理了头像=================");

        if(lifeImgFiles.length > 0) {
            for (MultipartFile imgFile : lifeImgFiles) {
                imgFile.transferTo(new File("D:\\img\\" + imgFile.getOriginalFilename()));
            }
            System.out.println("==================生活照保存结束==========================");
        }
        System.out.println(headerImgfile);
        System.out.println(lifeImgFiles);
        System.out.println(person);
        return "ok";
    }

    /**
     * HttpEntity：封装请求头、请求体； 把整个请求拿过来
     *      泛型：<String>：请求体类型；  可以自动转化
     * @param httpEntity
     * @return
     */
    @RequestMapping("/handle09")
    public String handle09(HttpEntity<Person> httpEntity) {

        //1、拿到所有请求头
        HttpHeaders headers = httpEntity.getHeaders();
        System.out.println("请求头：" + headers);

        //2、拿到请求体
        Person body = httpEntity.getBody();
        System.out.println("请求体" + body);

        return "ok";

    }

    /**
     * 接收原生API
     * @param request
     * @param response
     */
    @RequestMapping("/handle10")
    public void handle10(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        System.out.println(username);

        response.getWriter().write("ok" + username);


    }

}
