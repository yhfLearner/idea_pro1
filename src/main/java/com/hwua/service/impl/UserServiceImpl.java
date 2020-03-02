package com.hwua.service.impl;

import com.hwua.entity.User;
import com.hwua.mapper.UserMapper;
import com.hwua.service.UserService;
/*import com.hwua.util.SqlSessionFactoryUtil;*/
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper = null;

    @Override
    public User login(User user) throws Exception {
        return userMapper.queryByUser(user);
    }

    @Override
    public boolean register(User user) throws Exception {
        return userMapper.insert(user) == 1 ? true : false;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userMapper.queryAll();
    }

    @Override
    public User findUserById(Long id) throws Exception {

        return userMapper.queryById(id);
    }
}
