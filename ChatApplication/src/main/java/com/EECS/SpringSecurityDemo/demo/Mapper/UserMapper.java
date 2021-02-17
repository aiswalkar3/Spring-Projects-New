package com.EECS.SpringSecurityDemo.demo.Mapper;

import com.EECS.SpringSecurityDemo.demo.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("Select * from USERS where username = #{username}")
    User getUser(String username);

    @Insert("Insert into USERS(username, salt, password, firstname, lastname) VALUES(#{username}, " +
            "#{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insert(User user);
}
