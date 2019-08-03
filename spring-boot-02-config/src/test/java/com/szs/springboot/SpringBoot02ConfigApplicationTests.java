package com.szs.springboot;

import com.szs.springboot.bean.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**SpringBoot 单元测试;
 *  可以在测试期间很方便地类似编码的方式一样
 *          进行自动注入等容器的功能;
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Test
    public void testHelloService(){
        boolean b=ioc.containsBean("helloService");
        System.out.println("helloService 存在吗? "+b);  //helloService 存在吗? true

//        String[] beans = ioc.getBeanDefinitionNames();
//        for (String beanName : beans) {
//            System.out.println("BeanName:" + beanName);
//        }      //https://blog.csdn.net/long243416336/article/details/80590032
    }


    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}

