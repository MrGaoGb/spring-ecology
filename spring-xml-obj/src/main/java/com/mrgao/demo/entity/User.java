package com.mrgao.demo.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "s",namespace = "sx",propOrder = {
//        "userName",
//        "age",
//        "aliasUserName",
//        "password",
//        "ordinary"
//})
@XmlSeeAlso(AccountUser.class)
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
