package com.mrgao.demo.config;

import com.mrgao.demo.constants.CurrentDataSourceContext;
import com.mrgao.demo.constants.DataSourceContextConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Gao
 * @date 2023/3/16 14:12
 * @apiNote:
 */
@Slf4j
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    @Qualifier("datasourceRead")
    private DataSource datasourceRead;
    @Autowired
    @Qualifier("datasourceWrite")
    private DataSource datasourceWrite;

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = CurrentDataSourceContext.getDataSourceName();
        if (StringUtils.isEmpty(dataSourceName)) {
            dataSourceName = DataSourceContextConstants.DATASOURCE_READ;
        }
        log.info("CURRENT OPERATE DATASOURCE IS [{}] DATABASE CONNECT!", dataSourceName);
        return dataSourceName;
    }

    @Override
    public void afterPropertiesSet() {
        // 设置多数据源
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        targetDataSources.put(DataSourceContextConstants.DATASOURCE_READ, datasourceRead);
        targetDataSources.put(DataSourceContextConstants.DATASOURCE_WRITE, datasourceWrite);
        super.setTargetDataSources(targetDataSources);
        // 设置默认数据源
        super.setDefaultTargetDataSource(datasourceRead);
        super.afterPropertiesSet();
    }
}
