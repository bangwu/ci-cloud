package com.cloud.ci.service.impl;

import com.cloud.ci.mappers.UserMapper;
import com.cloud.ci.model.User;
import com.cloud.ci.service.UserService;
import com.cloud.ci.util.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private SqlSession sqlSession;

    public UserServiceImpl() {
        this.sqlSession = MySqlSessionFactory
                .getSqlSessionFactory()
                .openSession(true);
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public boolean save(User user) {
        user.setId(UUID.randomUUID().toString());
        userMapper.save(user);
        User newUser = userMapper.findUserByName(user.getUsername());
        return user.equals(newUser);
    }

    @Override
    public boolean findUser(User user) {
        User oldUser = userMapper.findUserByName(user.getUsername());
        return user.equals(oldUser);
    }
}
