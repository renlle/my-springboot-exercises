package com.szs.springboot04.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/2 11:14
 */
public class MyFilter implements Filter {
    public MyFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter正在初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter 正在Process...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
