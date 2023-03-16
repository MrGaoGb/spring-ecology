package com.mrgao.demo.service;

import com.mrgao.demo.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> listUser();

    /**
     * 添加用户
     *
     * @param user
     */
    void insert(User user);
}
