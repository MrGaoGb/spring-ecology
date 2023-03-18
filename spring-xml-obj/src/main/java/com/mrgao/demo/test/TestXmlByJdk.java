package com.mrgao.demo.test;

import com.mrgao.demo.entity.Ordinary;
import com.mrgao.demo.entity.User;
import com.mrgao.demo.utils.XmlObjUtils;

import java.io.IOException;
import java.math.BigDecimal;

public class TestXmlByJdk {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setUserName("高启强");
        user.setAliasUserName("鱼贩子");
        user.setPassword("123456");
        user.setAge(35);
        user.setOrdinary(new Ordinary(new BigDecimal("10"), new BigDecimal("0.38")));
        String toXml = XmlObjUtils.convertToXml(user);
        System.out.println("--------obj to xml---------");
        System.out.printf(toXml);
        System.out.println("--------xml to obj ---------");
        User userConvertObj = XmlObjUtils.convertXmlStrToObject(User.class, toXml);
        System.out.printf("--" + userConvertObj);
    }
}
