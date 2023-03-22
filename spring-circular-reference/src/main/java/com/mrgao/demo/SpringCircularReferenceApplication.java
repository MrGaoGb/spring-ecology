package com.mrgao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// @EnableTransactionManagement 开启事务管理器
public class SpringCircularReferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCircularReferenceApplication.class, args);
    }

}
