package com.atguigu.springmvc.bean;

import lombok.Data;

/**
 * @author thebigpotato
 * @create 2025-04-26-19:55
 */

/**
 * username=张三&password=123456&cellphone=12121215566&agreement=on
 * &address.province=陕西&address.city=西安&address.area=雁塔
 * &sex=男&hobby=足球&hobby=篮球&grade=二年级
 *
 */

@Data // JavaBean定死的数据模型，定不死的写Map
public class Person {
    //请求参数：username=ywh&password=123456&cellphone=313254165&agreement=on
    //名称要与url的名称对应上，不然要么为null要么为默认值
    private String username ;
    private String password;
    private String cellphone;
    private boolean agreement;

    private Address address;//在底下再写一个Address类

    private String sex;
    private String[] hobby;// 因为在上面参数中，hobby出现了多次，所以用数组
    private String grade;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}

@Data
class Address {
    private String province;
    private String city;
    private String area;
}
