package com.atguigu.practice.exception;

/**
 * ClassName: BizException
 * Package: com.atguigu.practice.exception
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/9 11:25
 * @Version 19
 */

import lombok.Data;

/**
 * 业务异常
 * 大型系统出现以下异常：异常处理文档，固化 用枚举来定死
 * 1、订单 1xxxx
 *      10001 订单已关闭
 *      10002 订单不存在
 *      10003 订单不超时
 *      ......
 * 2、商品 2xxxx
 *      20001 商品已下架
 *      20002 商品已售完
 *      ......
 *
 * 3、用户
 *      30001 用户已注册
 *      30002 用户已登录
 *      30003 用户已注销
 *      30004 用户已过期
 *      ......
 *
 * 4、支付
 *      40001 支付失败
 *      40002 余额不足
 *      40003 支付渠道异常
 *      ......
 * 5、物流
 *      50001 物流状态错误
 *      50002 新疆得加钱
 *      50003 物流异常
 *      50004 物流超时
 *      ......
 * 异常处理的最终方式
 * 1、必须有业务异常类：BizException
 * 2、必须有异常枚举类：BizExceptionEnume 列举项目中每个模块将会出现的所有异常情况
 * 3、编写业务代码的时候，只需要编写正确逻辑，如果出现预期的问题，需要以抛异常的方式中断逻辑并通知上层
 * 4、必须要有全局异常处理器：GlobalExceptionHandler：处理所有异常，返回给前端约定的json数据与错误码
 *
 *
 *
 */
@Data
public class BizException extends RuntimeException {
    private Integer code;// 业务异常码
    private String msg;// 业务异常信息

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnume exceptionEnume) {
        super(exceptionEnume.getMsg());
        this.code = exceptionEnume.getCode();
        this.msg = exceptionEnume.getMsg();
    }

}
