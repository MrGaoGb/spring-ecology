package com.mrgao.demo.utils;

import com.mrgao.demo.config.DataSourceContext;
import com.mrgao.demo.constants.DataSourceContextConstants;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author Mr.Gao
 * @date 2023/3/16 14:49
 * @apiNote:
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        try {
            DataSourceContext.put(DataSourceContextConstants.DATASOURCE_READ, getBean(DataSourceContextConstants.DATASOURCE_READ, DataSource.class));
            DataSourceContext.put(DataSourceContextConstants.DATASOURCE_WRITE, getBean(DataSourceContextConstants.DATASOURCE_WRITE, DataSource.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Bean信息
     *
     * @param beanName
     * @param classType
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T getBean(String beanName, Class<T> classType) throws Exception {
        T bean = applicationContext.getBean(beanName, classType);
        if (Objects.isNull(bean)) {
            throw new Exception(beanName + "对象不存在!");
        }
        return bean;
    }
}
