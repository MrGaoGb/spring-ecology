package com.mrgao.demo.annotation;

import com.mrgao.demo.constants.DataSourceContextConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mr.Gao
 * @date 2023/3/16 18:05
 * @apiNote:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * 指定数据源
     *
     * @return
     */
    String value() default DataSourceContextConstants.DATASOURCE_READ;
}
