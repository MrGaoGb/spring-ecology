package com.mrgao.demo.service.impl;

import com.mrgao.demo.entity.User;
import com.mrgao.demo.mapper.UserMapper;
import com.mrgao.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mr.Gao
 * @date 2023/3/10 13:49
 * @apiNote:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.findAll();
    }

    @Override
    public void insert() {
        User user = new User();
        // ThreadLocalRandom 生成随机年龄
        int age = ThreadLocalRandom.current().nextInt(1, 100);
        user.setAge(ThreadLocalRandom.current().nextInt(1, 100));
        if (age % 2 == 0) {
            user.setGender(0);
            user.setUserName("张" + UUID.randomUUID().toString().substring(0, 8));
        } else {
            user.setGender(1);
            user.setUserName("高" + UUID.randomUUID().toString().substring(0, 8));
        }
        user.setPassword(UUID.randomUUID().toString().substring(0, 5));
        userMapper.save(user);
    }
}
