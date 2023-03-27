package com.mrgao.demo.config;

import com.mrgao.demo.constants.XomConstants;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public XomParseProcess xmlObjParseProcess(@Qualifier("jaxb2Marshaller") Jaxb2Marshaller jaxb2Marshaller) {
        return new XomParseProcess(jaxb2Marshaller.createMarshaller(), jaxb2Marshaller.createUnmarshaller());
    }


    /**
     * 配置编码器和解码器
     *
     * @return
     */
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(XomConstants.SCAN_PACKAGES);

        // --配置属性
        Map<String, Object> configPropMap = new HashMap<>(4);
        // --配置输出XML是否格式化输出
        configPropMap.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // --配置编码字符集
        configPropMap.put(Marshaller.JAXB_ENCODING, XomConstants.ENCODING);
        jaxb2Marshaller.setMarshallerProperties(configPropMap);

        return jaxb2Marshaller;
    }
}
