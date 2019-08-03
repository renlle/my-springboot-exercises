package com.szs;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行demo控制器............");

        Users users=new Users(); //建立pojo对象
        users.setId(1);
        users.setPassword("123456");
        users.setUsername("张三");

        Users users2=new Users(); //建立pojo对象2
        users2.setId(2);
        users2.setPassword("123456");
        users2.setUsername("李四");

        ArrayList<Users> list=new ArrayList();
        list.add(users);
        list.add(users2);

        ObjectMapper mapper = new ObjectMapper(); //将对象转化为json字符串
        String result= mapper.writeValueAsString(list);

                            //请求头:MIME 格式;
        resp.setContentType("application/json;charset=utf-8"); //设置json字符流为utf-8
        PrintWriter out = resp.getWriter();
     //   out.print("服务器返回的内容: \n");
        out.println(result);

        out.flush();
        out.close();
    }
}
