package com.atguigu.practice.common;

import lombok.Data;

/**
 * ClassName: R
 * Package: com.atguigu.rest.crud.common
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/7 10:58
 * @Version 19
 */

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static<T> R<T> ok(T data) {
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMsg("成功");
        tr.setData(data);
        return tr;
    }

    public static R ok() {
        R tr = new R<>();
        tr.setCode(200);
        tr.setMsg("成功");
        return tr;
    }

    public static R error(Integer code,String msg) {
        R tr = new R<>();
        tr.setCode(code); //默认失败码
        tr.setMsg(msg);
        return tr;
    }

    public static<T> R<T> error(Integer code,String msg,T data) {
        R<T> tr = new R<>();
        tr.setCode(500); //默认失败码
        tr.setMsg("error");
        tr.setData(data);
        return tr;
    }


}
