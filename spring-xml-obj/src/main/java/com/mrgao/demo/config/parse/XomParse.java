package com.mrgao.demo.config.parse;

/**
 * @author Mr.Gao
 * @date 2023/4/10 15:20
 * @apiNote:
 */
public interface XomParse {

    /**
     * 对象转化为XML
     *
     * @param bizBody
     * @return
     * @throws Exception
     */
    public String objToXml(Object bizBody) throws Exception;

    /**
     * XML转化为对象
     *
     * @param xmlBody
     * @param tClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T xmlToObj(String xmlBody, Class<T> tClass) throws Exception;
}
