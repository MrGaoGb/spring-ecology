package com.mrgao.demo.config;


import com.mrgao.demo.pocessor.CustomAopBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"com.mrgao.demo"})
@Configuration
@Import(CustomAopBeanPostProcessor.class)
public class AspectConfig {
}
