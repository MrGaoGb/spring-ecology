package com.mrgao.demo.mapper.r;

import com.mrgao.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RUserMapper {


    @Select("select * from user")
    List<User> findList();

    @Insert("insert into user(user_name,password,age,gender) values(#{userName},#{password},#{age},#{gender})")
    int save(User user);

}
