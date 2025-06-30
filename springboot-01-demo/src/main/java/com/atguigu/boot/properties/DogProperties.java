package com.atguigu.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: DogProperties
 * Package: com.atguigu.boot.properties
 * Description:
 *
 * @Author the big potato
 * @Create 2025/6/30 19:58
 * @Version 19
 */

@ConfigurationProperties(prefix = "dog")
//@Component 不在这放入容器，还可以在主程序文件内 ：@EnableConfigurationProperties(DogProperties.class )
@Data
public class DogProperties {
    private String name;
    private int age;
    private String gender;


}
