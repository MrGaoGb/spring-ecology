package com.mrgao.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0-男 1-女
     */
    private Integer gender;
}
