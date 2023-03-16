package com.mrgao.demo.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    /**
     * 数据源1
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSource dataSource1() {
        // 底层会拿到spring.datasource中的配置，创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 数据源2
     *
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2() {
        // 底层会拿到spring.datasource中的配置，创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }
}
