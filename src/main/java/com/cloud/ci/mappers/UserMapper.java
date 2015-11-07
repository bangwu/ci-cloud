package com.cloud.ci.mappers;

import com.cloud.ci.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into users (id, username, password) values(#{id}, #{username}, #{password})")
    void save(User user);

    @Select("select id, username, password from users where username=#{username} limit 1")
    User findUserByName(String username);
}
