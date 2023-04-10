package com.mrgao.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mrgao.demo.config.parse.JacksonXomParse;
import com.mrgao.demo.config.parse.XomParse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author Mr.Gao
 * @date 2023/4/10 11:53
 * @apiNote: Jackson Xom配置类 优先加载JacksonXom
 */
@Order(200)
@Configuration
public class JacksonXomConfiguration {

    @Bean
    public XmlMapper xmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        // 忽略实体中不含有的字段
        xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        // 忽略未知字段
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 输出格式化
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return xmlMapper;
    }

    @Bean
    public XomParse xomParse(@Qualifier("xmlMapper") XmlMapper xmlMapper) {
        return new JacksonXomParse(xmlMapper);
    }
}
