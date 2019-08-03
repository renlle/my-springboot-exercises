package com.szs.springboot07mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* Copyright (C), 2018-2019, ZhengZhouChuangZhi. Co., Ltd.* FileName: DruidConfig.java
* 类的详细说明: 导入Druid数据源
*
* @author 宋泽山
* @date 2019/3/11 9:22
* @version 1.0
*/
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * @description 配置Druid的监控
     * @author 宋泽山
     * @date 2019/3/11 9:19
     * @param []
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> initParams = new HashMap<>(10);
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        //默认允许所有的进行访问
        initParams.put("allow", "");

        bean.setInitParameters(initParams);
        return bean;
    }
    /** 2.配置一个web监控的filter */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>(6);
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
