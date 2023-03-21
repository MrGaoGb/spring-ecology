package com.mrgao.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class XomConfiguration {

    /**
     * 配置XML解析器
     *
     * @return
     */
    @Bean
    public XomParseProcess xmlObjParseProcess() {
        return new XomParseProcess(jaxb2Marshaller().createMarshaller(), jaxb2Marshaller().createUnmarshaller());
    }


    /**
     * 配置编码器和解码器
     *
     * @return
     */
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("com.mrgao.demo.entity");

        // --配置属性
        Map<String, Object> configPropMap = new HashMap<>(4);
        configPropMap.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        configPropMap.put(Marshaller.JAXB_ENCODING, "GBK");
        jaxb2Marshaller.setMarshallerProperties(configPropMap);

        return jaxb2Marshaller;
    }
}
