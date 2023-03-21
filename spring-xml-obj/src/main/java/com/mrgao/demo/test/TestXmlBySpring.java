package com.mrgao.demo.test;

import com.mrgao.demo.config.XomConfiguration;
import com.mrgao.demo.config.XomParseProcess;
import com.mrgao.demo.entity.AccountUser;
import com.mrgao.demo.entity.Ordinary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

public class TestXmlBySpring {
    public static void main(String[] args) throws Exception {

        AccountUser user = new AccountUser();
        user.setUserName("高启强");
        user.setAliasUserName("鱼贩子");
        user.setPassword("123456");
        user.setAge(35);
        user.setAccountUUid(UUID.randomUUID());
        user.setOrdinary(new Ordinary(new BigDecimal("10"), new BigDecimal("0.38")));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XomConfiguration.class);
//        Jaxb2Marshaller jaxb2Marshaller = context.getBean("jaxb2Marshaller", Jaxb2Marshaller.class);
//        // --TODO 获得编码器
//        Marshaller marshaller = jaxb2Marshaller.createMarshaller();
//        StringWriter stringWriter = new StringWriter();
//        marshaller.marshal(user, stringWriter);
//
//        // --Object to XML
//        String objToXMl = stringWriter.toString();
//        System.out.println("---------Object to XML-----------");
//        System.out.println(objToXMl);
//
//        // --TODO 获得解码器
//        Unmarshaller unmarshaller = jaxb2Marshaller.createUnmarshaller();
//        System.out.println("---------XML to Object -----------");
//        StringReader stringReader = new StringReader(objToXMl);
//        User xmlToObj = (User) unmarshaller.unmarshal(stringReader);
//        System.out.println(xmlToObj);

        // 获取包装类
        XomParseProcess xomParseProcess = context.getBean(XomParseProcess.class);
        // --TODO 编码器
        System.out.println("---------Object to XML-----------");
        String objToXMl = xomParseProcess.objToXml(user);
        System.out.println(objToXMl);
        // --TODO 解码器
        System.out.println("---------XML to Object-----------");
        AccountUser xmlToObj = xomParseProcess.xmlToObj(objToXMl, AccountUser.class);
        System.out.println(xmlToObj);
    }
}
