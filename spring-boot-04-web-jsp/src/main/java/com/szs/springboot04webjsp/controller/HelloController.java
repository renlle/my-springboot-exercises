package com.szs.springboot04webjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/2 17:09
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好!");
        return "success";
    }
}
