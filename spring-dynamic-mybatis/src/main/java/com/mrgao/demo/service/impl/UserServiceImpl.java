package com.mrgao.demo.service.impl;

import com.mrgao.demo.entity.User;
import com.mrgao.demo.mapper.r.RUserMapper;
import com.mrgao.demo.mapper.w.WUserMapper;
import com.mrgao.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RUserMapper rUserMapper;

    private final WUserMapper wUserMapper;

    /**
     * 从库
     *
     * @return
     */
    @Override
    public List<User> listUser() {
        return rUserMapper.findList();
    }

    /**
     * 主库
     *
     * @param user
     */
    @Override
    public void insert(User user) {
        wUserMapper.save(user);
    }
}
