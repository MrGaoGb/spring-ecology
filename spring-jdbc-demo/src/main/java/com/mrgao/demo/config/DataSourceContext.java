package com.mrgao.demo.config;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.Gao
 * @date 2023/3/16 14:38
 * @apiNote:
 */
public class DataSourceContext {

    public static final Map<String, DataSource> DATA_SOURCE_MAP = new ConcurrentHashMap<>(16);

    /**
     * 添加数据源
     *
     * @param beanName
     * @param dataSource
     */
    public static void put(String beanName, DataSource dataSource) {
        DATA_SOURCE_MAP.put(beanName, dataSource);
    }

    /**
     * 获取数据源
     *
     * @param beanName
     * @return
     */
    public static DataSource get(String beanName) {
        return DATA_SOURCE_MAP.get(beanName);
    }

}
