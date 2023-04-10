package com.mrgao.demo.config;

import com.mrgao.demo.config.parse.JaxbXomParse;
import com.mrgao.demo.config.parse.XomParse;
import com.mrgao.demo.constants.XomConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Gao
 * @date 2023/3/21 18:11
 * @apiNote:Jax2Xom配置类
 */
@Configuration
@Order(300)
@ConditionalOnMissingBean(JacksonXomConfiguration.class)
public class JaxbXomConfiguration {

    /**
     * 配置XML解析器
     *
     * @return
     */
    @Bean
    public XomParse xomParse(@Qualifier("jaxb2Marshaller") Jaxb2Marshaller jaxb2Marshaller) {
        return new JaxbXomParse(jaxb2Marshaller.createMarshaller(), jaxb2Marshaller.createUnmarshaller());
    }

    /**
     * 配置编码器和解码器
     *
     * @return
     */
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        // 配置扫描包
        jaxb2Marshaller.setPackagesToScan(XomConstants.SCAN_PACKAGES);

        // --配置属性
        Map<String, Object> configPropMap = new HashMap<>(4);
        configPropMap.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        configPropMap.put(Marshaller.JAXB_ENCODING, XomConstants.ENCODING);
        jaxb2Marshaller.setMarshallerProperties(configPropMap);

        return jaxb2Marshaller;
    }
}
