package com.mrgao.demo.service;

import com.mrgao.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {


    public List<User> findUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User("阿三",32));
        list.add(new User("吕德华",26));
        list.add(new User("赖神",25));
        return list;
    }

    public UserService(){
        System.out.println("---------create user object-----");
    }

}
