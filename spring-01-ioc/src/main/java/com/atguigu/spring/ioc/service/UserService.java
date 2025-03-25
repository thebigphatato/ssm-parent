package com.atguigu.spring.ioc.service;

import com.atguigu.spring.ioc.bean.Dog;
import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.dao.UserDao;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.atguigu.spring.ioc.service
 * Description:
 *
 * @Author the big potato
 * @Create 2025/3/13 21:11
 * @Version 19
 */

@ToString
@Data
@Service
public class UserService {

//    @Qualifier("bill")//精确指定：如果容器中这样的组件存在多个，则使用@Qualifier精确指定组件名
    @Qualifier("bill")  //精确指定：如果容器中这样的组件存在多个，且有默认组件，我们可以使用@Qualifier("组件名称")切换别的组件
                        // 当你用到@Primary的时候，调用的时候哪怕你名称用的组件的名称，但是还是会去取主组件，
                        //所以当取其他的组件的时候，就一定要用到@Qualifier("组件名称")
                        //@Primary一旦存在，改属性名就不能实现组件切换了

    @Autowired
    Person atom;


    // 面试题：@Resource 和 @Autowired的区别？
    // 1. @Autowired 和 @Resource 都是做bean的注入用的，都可以放在属性上
    // 2. @Autowired
    ///3. @Resource具有更强的通用性 因为它是JAVAEE标准的子包，而@Autowired是Spring框架下的包，
    //              如果框架改了，则它就失效了，但@Resource不受影响
    //    @Autowired里有required属性

    @Resource//Resource这个包来自于jakarta，它的前身是javax，这个是JAVAEE标准。
    UserDao userDao;

//    @Autowired(required = false)
//    Dog dog.properties;//当我们取消DogConfig为配置类的时候，没有的话获取容器的时候就返回null

//    @Resource
//    Dog dog.properties;//没有机会报错，所以以后咱就用@Autowired，因为Spring独占市场了

}
