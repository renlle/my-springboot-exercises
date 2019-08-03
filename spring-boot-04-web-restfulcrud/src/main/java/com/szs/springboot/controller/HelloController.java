package com.szs.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorld!";
    }

    //查出一些数据,在页面显示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //public static final String DEFAULT_PREFIX = "classpath:/templates/"
        map.put("hi", "你好啊!QWQ");
        return "success";
    }
}
