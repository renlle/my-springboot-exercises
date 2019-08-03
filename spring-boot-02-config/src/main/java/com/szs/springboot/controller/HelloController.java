package com.szs.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("#{person.toString()}")
    private String info;
    @RequestMapping("/sayHello")
    public String method1(){
        return "hello "+info;
    }
}
