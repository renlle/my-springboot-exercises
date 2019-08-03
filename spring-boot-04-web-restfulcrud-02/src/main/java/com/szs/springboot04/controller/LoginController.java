package com.szs.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
/**
 *@Author SongZeShan
 *@Email renlle@qq.com
 *@Create ${DATE} ${TIME}
 */
@Controller
public class LoginController {
//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @PostMapping(value = "/user/login")
    /** 等价的写法
     * @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     */
    public String login(@RequestParam("username") String username, HttpSession session,
                        @RequestParam("password") String password, Map<String,Object> map){
        String rightPassword="123456";
        if(!"".equals(username) &&rightPassword.equals(password)){
            session.setAttribute("loginUser",username);
            //登陆成功,防止表单重复提交.可以重定向到后台主页dashboard
            return "redirect:/main.html";
        }
        else {
            map.put("msg", "用户名或者密码错误");
            //登陆失败,c重新返回登录页面
            return "login";
        }
    }

    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }
}
