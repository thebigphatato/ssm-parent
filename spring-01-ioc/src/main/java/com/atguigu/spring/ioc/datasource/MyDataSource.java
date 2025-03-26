package com.atguigu.spring.ioc.datasource;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyDataSource
 * Package: com.atguigu.spring.ioc.datasource
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/26 14:47
 * @Version 19
 */

@Component
@Data
public class MyDataSource {
    private String url;
    private String username;
    private String password;
}
