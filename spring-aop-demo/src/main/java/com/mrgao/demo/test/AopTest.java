package com.mrgao.demo.test;

import com.mrgao.demo.config.AspectConfig;
import com.mrgao.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP测试类
 */
public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.findUserList().forEach(System.out::println);
    }
}

