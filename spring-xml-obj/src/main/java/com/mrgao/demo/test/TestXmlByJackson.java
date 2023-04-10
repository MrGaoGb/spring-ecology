package com.mrgao.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrgao.demo.config.JacksonXomConfiguration;
import com.mrgao.demo.config.JaxbXomConfiguration;
import com.mrgao.demo.config.parse.XomParse;
import com.mrgao.demo.entity.jacksonxml.OrgAgentInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.UUID;

/**
 * @author Mr.Gao
 * @date 2023/4/10 10:46
 * @apiNote:
 */
public class TestXmlByJackson {
    public static void main(String[] args) throws Exception {
        //
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JacksonXomConfiguration.class, JaxbXomConfiguration.class);
        ObjectMapper bean = applicationContext.getBean(ObjectMapper.class);
        System.out.println("ObjectMapper:" + bean);
        XomParse xomParse = applicationContext.getBean(XomParse.class);
        System.out.println("xomParseProcess:" + xomParse);
        OrgAgentInfo user = new OrgAgentInfo();
        user.setUserName("高启强");
        user.setUserNo("1234567890");
        user.setUserPwd("123456");
        user.setOrgCode(UUID.randomUUID().toString());
        String xml = xomParse.objToXml(user);
        System.out.println(xml);
        OrgAgentInfo orgAgentInfo = xomParse.xmlToObj(xml, OrgAgentInfo.class);
        System.out.println(JSONObject.toJSONString(orgAgentInfo));

        Jaxb2Marshaller jaxb2Marshaller = applicationContext.getBean(Jaxb2Marshaller.class);
        System.out.println("jaxb2Marshaller:" + jaxb2Marshaller);


    }
}
