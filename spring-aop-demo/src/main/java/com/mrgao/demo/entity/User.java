package com.mrgao.demo.entity;

import lombok.Data;

@Data
public class User {

    private String userName;

    private Integer age;

    public User(String userName,Integer age){
        this.userName = userName;
        this.age = age;
    }

    public User(){}
}
