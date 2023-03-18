package com.mrgao.demo.test;

import com.mrgao.demo.config.XmlConfiguration;
import com.mrgao.demo.config.XmlObjParseProcess;
import com.mrgao.demo.entity.Ordinary;
import com.mrgao.demo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;

public class TestXmlBySpring {
    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setUserName("高启强");
        user.setAliasUserName("鱼贩子");
        user.setPassword("123456");
        user.setAge(35);
        user.setOrdinary(new Ordinary(new BigDecimal("10"), new BigDecimal("0.38")));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XmlConfiguration.class);
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
        XmlObjParseProcess xmlObjParseProcess = context.getBean(XmlObjParseProcess.class);
        // --TODO 编码器
        System.out.println("---------Object to XML-----------");
        String objToXMl = xmlObjParseProcess.objToXml(user);
        System.out.println(objToXMl);
        // --TODO 解码器
        System.out.println("---------XML to Object-----------");
        User xmlToObj = xmlObjParseProcess.xmlToObj(objToXMl, User.class);
        System.out.println(xmlToObj);
    }
}
