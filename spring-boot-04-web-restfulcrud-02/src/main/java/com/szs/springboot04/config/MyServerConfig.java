package com.szs.springboot04.config;

import com.szs.springboot04.filter.MyFilter;
import com.szs.springboot04.listener.MyListener;
import com.szs.springboot04.servlet.MyServlet;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author SongZeShan
 * @Email renlle@qq.com
 * @Create 2019/3/2 10:33
 */
@Configuration
public class MyServerConfig {
    /**
     * 注册三大组件
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        return  new ServletListenerRegistrationBean<>(new MyListener());
    }

    /**
     * 配置嵌入式的Servlet容器
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return ( container->
                container.setPort(8081)
            );
    }
}
