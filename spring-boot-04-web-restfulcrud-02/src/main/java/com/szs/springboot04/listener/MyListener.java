package com.szs.springboot04.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/2 11:31
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized ...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed... web项目已经销毁");
    }
}
