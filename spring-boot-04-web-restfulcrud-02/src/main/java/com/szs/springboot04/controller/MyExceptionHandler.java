package com.szs.springboot04.controller;
import com.szs.springboot04.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/1 16:13
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 第一种写法: 浏览器和客户端返回的都是json数据!
     * @param e
     * @return
    //    @ResponseBody
    //    @ExceptionHandler(UserNotExistException.class)
    //    public Map<String, Object> handleException(Exception e){
    //        Map<String,Object> map=new HashMap<>();
    //        map.put("code","user.notexist");
    //        map.put("message", e.getMessage());
    //
    //        return map;
    //    }
     */

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>(10);
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code","user.notexist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        //转发到/error页面
        return "forward:/error";
    }
}
