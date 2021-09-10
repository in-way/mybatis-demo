package com.batis.demo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@SpringBootApplication
public class BatisApplication {
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(BatisApplication.class, args);
    }
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        BatisApplication.applicationContext = applicationContext;
    }
    public static <T> T getBean(String name) {
        try {
            return (T) applicationContext.getBean(name);
        } catch (BeansException e) {
            return null;
        }
    }
    public static <T> T getBean(Class<T> clazz) {
        Map<String, T> beans = applicationContext.getBeansOfType(clazz);
        if (beans.size() <= 0) {
            return null;
        }
        return Lists.newArrayList(beans.values()).get(0);
    }
}
