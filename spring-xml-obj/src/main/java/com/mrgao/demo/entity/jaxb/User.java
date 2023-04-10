package com.mrgao.demo.entity.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "s",namespace = "sx",propOrder = {
//        "userName",
//        "age",
//        "aliasUserName",
//        "password",
//        "ordinary"
//})
@XmlSeeAlso(AccountUser.class) // 可以指定子类 方便XML解析
public class User {

    @XmlElement(defaultValue = "")
    private String password;
    @XmlElement(name = "user_name")
    private String userName;
    private Integer age;
    @XmlElement(name = "alias_user_name")
    private String aliasUserName;

    // 存在值的时候 会被转化为xml 否则没有该字段
    //@XmlElementWrapper 对应list集合
    private Ordinary ordinary;
}
