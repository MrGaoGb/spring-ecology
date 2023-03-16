package com.mrgao.demo.mapper.w;

import com.mrgao.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WUserMapper {


    @Select("select * from user")
    List<User> findList();

    @Insert("insert into user(user_name,password,age,gender) values(#{userName},#{password},#{age},#{gender})")
    int save(User user);

}
