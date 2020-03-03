package com.dxh.bookillustration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //addResourceHandler是指定的虚拟路径，addResourceLocations是自己的物理路径，
        registry.addResourceHandler("/file/**").addResourceLocations("file:E:/");
        super.addResourceHandlers(registry);
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("设置了主页");
        //设置主页
        registry.addViewController("/").setViewName("redirect:/user");
        //设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        //将主页注册器添加到视图控制器中
        super.addViewControllers(registry);
    }
}
