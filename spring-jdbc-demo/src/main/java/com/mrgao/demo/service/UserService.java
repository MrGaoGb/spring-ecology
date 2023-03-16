package com.mrgao.demo.service;

import com.mrgao.demo.entity.User;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/3/10 13:25
 * @apiNote:
 */
public interface UserService {
    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> listUser();

    /**
     * 添加用户
     */
    void insert();
}
