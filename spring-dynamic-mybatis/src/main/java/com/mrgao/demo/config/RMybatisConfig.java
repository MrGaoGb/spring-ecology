package com.mrgao.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Mr.Gao
 * @date 2023/3/1 13:31
 * @apiNote:写数据源
 */
@Configuration
@MapperScan(basePackages = {"com.mrgao.demo.mapper.r"}, sqlSessionFactoryRef = "rSqlSessionFactory")
public class RMybatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
    public DataSource dataSource2() {
        // 底层会拿到spring.datasource中的配置，创建一个DruidDataSource
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory rSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource2) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 指定主库
        sessionFactory.setDataSource(dataSource2);
        // 指定主库对应的Mapper文件
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/r/*.xml"));
        /*设置SQL控制台打印*/
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }

    /**
     * 配置事务管理器
     *
     * @return
     */
//    @Bean
//    public DataSourceTransactionManager wDataSourceTransactionManager() {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource2());
//        return dataSourceTransactionManager;
//    }
}
