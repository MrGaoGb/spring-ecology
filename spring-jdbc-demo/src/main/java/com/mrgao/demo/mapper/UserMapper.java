package com.mrgao.demo.mapper;


import com.mrgao.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/3/10 13:39
 * @apiNote:
 */
public interface UserMapper {

    /**
     * 获取所有用户
     *
     * @return
     */
    @Select("SELECT  *  FROM user_inf")
    List<User> findAll();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Insert("INSERT INTO user_inf(user_name,  password,  age,  gender)  VALUES(#{userName},  #{password},  #{age},  #{gender})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int save(User user);
}
