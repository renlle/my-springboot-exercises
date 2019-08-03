package com.szs.springboot.config;

import com.szs.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 为配置类,指明当前类是一个配置类；
 *      就是来替代之前的Spring配置文件:之前在配置文件中用<bean><bean/>标签添加组件
 */
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中,容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类中的@Bean给容器中添加组件");
        return new HelloService();
    }
}
