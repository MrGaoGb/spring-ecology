package com.mrgao.demo.controller;

import com.mrgao.demo.entity.User;
import com.mrgao.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/3/10 13:59
 * @apiNote:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/user/list")
    public List<User> listUser() {
        return userService.listUser();
    }

    /**
     * 添加用户
     */
    @GetMapping("/user/save")
    public String insert() {
        log.info("添加用户逻辑开始执行...");
        userService.insert();
        log.info("添加用户逻辑添加完成...");
        return "SUCCESS";
    }
}
