package com.project.project.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("register");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/successfully_register").setViewName("redirect_register");
    }
}
