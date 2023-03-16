package com.mrgao.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Gao
 * @date 2023/3/10 13:45
 * @apiNote:
 */
@Configuration
@MapperScan(basePackages = "com.mrgao.demo.mapper")
public class MybatisConfig {
}
