package com.mrgao.demo.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    /**
     * 数据源读
     *
     * @return
     */
    @Bean(value = {})
    @ConfigurationProperties(prefix = "spring.datasource.datasourceread")
    public DataSource datasourceRead() {
        // 底层会拿到spring.datasource中的配置，创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 数据源写
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.datasourcewrite")
    public DataSource datasourceWrite() {
        // 底层会拿到spring.datasource中的配置，创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }
}
