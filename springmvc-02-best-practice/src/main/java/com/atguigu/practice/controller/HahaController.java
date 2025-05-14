package com.atguigu.practice.controller;

import com.atguigu.practice.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HahaController
 * Package: com.atguigu.practice.controller
 * Description:
 *
 * @Author the big potato
 * @Create 2025/5/9 10:44
 * @Version 19
 */

/**
 * 异常处理优先级：
 *      本类 》 全局
 *      精确 》 模糊
 */
@RestController
public class HahaController {

    @GetMapping("/haha")
    public R haha() {
        int i = 10 / 0;
        return R.ok();
    }
}
