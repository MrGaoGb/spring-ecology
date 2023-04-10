package com.mrgao.demo.config.parse;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mr.Gao
 * @date 2023/4/10 11:55
 * @apiNote:
 */
public class JacksonXomParse implements XomParse {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonXomParse.class);
    private final XmlMapper xmlMapper;

    public JacksonXomParse(XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    /**
     * 对象转化为XML
     *
     * @param bizBody
     * @return
     * @throws Exception
     */
    @Override
    public String objToXml(Object bizBody) throws Exception {
        try {
            return xmlMapper.writeValueAsString(bizBody);
        } catch (Exception e) {
            LOGGER.error("编码器IO转化异常:{}", e.getMessage());
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
    @Override
    public <T> T xmlToObj(String xmlBody, Class<T> tClass) throws Exception {
        try {
            return xmlMapper.readValue(xmlBody, tClass);
        } catch (Exception e) {
            LOGGER.error("解码器XML转化异常:{}", e.getMessage());
            throw new Exception("解码器XML转化异常");
        }
    }
}
