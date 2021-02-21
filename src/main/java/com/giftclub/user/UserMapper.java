package com.giftclub.user;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(name, email,  password, phone_number, birth) VALUES(#{user.name}, #{user.email},  #{user.password}, #{user.phoneNumber}, #{user.birth})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
        // 생성된 키를 가지고, "id" 에 대한 property 를 주세요.
    int insert(@Param("user") User user);


    @Select("SELECT * FROM user")
    @Results(id = "userMap",
            value = {@Result(property = "phoneNumber", column = "phone_number")})
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id=#{id}")
    @ResultMap("userMap")
    User getById(@Param("id") int id);

}
