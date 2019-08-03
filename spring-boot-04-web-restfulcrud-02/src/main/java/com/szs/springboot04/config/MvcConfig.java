package com.szs.springboot04.config;
import com.szs.springboot04.component.LoginHandlerInterceptor;
import com.szs.springboot04.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//使用WebMvcConfigurerAdapter来扩展SpringMVC的功能
//@EnableWebMvc
/**
 *@Author SongZeShan
 *@Email renlle@qq.com
 *@Create ${DATE} ${TIME}
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    /**
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用,将该组件注册到容器中
     * @return
     */
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/szs").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override//注册一个拦截器
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源 *.css,*.js ,springboot已经不需要再处理静态资源了;
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
