package com.szs.springboot04;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
/**
 *@Author SongZeShan
 *@Email renlle@qq.com
 *@Create ${DATE} ${TIME}
 */
@SpringBootApplication
public class SpringBoot04WebRestfulcrydApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrydApplication.class, args);
    }

    @Bean
    public ViewResolver myViewReolver(){
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

}
