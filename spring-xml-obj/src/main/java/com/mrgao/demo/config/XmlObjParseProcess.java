package com.mrgao.demo.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML或对象解析器
 */
@AllArgsConstructor
@NoArgsConstructor
public class XmlObjParseProcess {

    private Marshaller marshaller;

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
            return (T) unmarshaller.unmarshal(new StreamSource(stringWriter));
        } catch (Exception e) {
            throw new Exception("解码器XML转化异常");
        }
    }

}
