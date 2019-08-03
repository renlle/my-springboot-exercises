package com.szs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用注解@SpringBootApplication 来标注一个Spring应用;
 *
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {

        //Spring 应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);

    }
}
