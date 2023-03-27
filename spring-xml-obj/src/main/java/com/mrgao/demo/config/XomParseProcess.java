package com.mrgao.demo.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Mr.Gao
 * @date 2023/3/21 18:12
 * @apiNote:
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class XomParseProcess {
    // 编码器
    private Marshaller marshaller;
    // 解码器
    private Unmarshaller unmarshaller;

    /**
     * 对象转化为XML
     *
     * @param bizBody
     * @return
     * @throws Exception
     */
    public String objToXml(Object bizBody) throws Exception {
        try {
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(bizBody, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            log.error("编码器IO转化异常:{}", e.getMessage());
            throw new Exception("编码器IO转化异常");
        }
    }

    /**
     * XML转化为对象
     *
     * @param xmlBody
     * @param tClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T xmlToObj(String xmlBody, Class<T> tClass) throws Exception {
        try {
            StringReader stringWriter = new StringReader(xmlBody);
            // 获取对象JAXBElement
            JAXBElement<T> jaxbElement = unmarshaller.unmarshal(new StreamSource(stringWriter), tClass);
            return jaxbElement.getValue();
        } catch (Exception e) {
            log.error("解码器XML转化异常:{}", e.getMessage());
            throw new Exception("解码器XML转化异常");
        }
    }
}
