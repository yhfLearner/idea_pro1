package com.hwua.service;

import com.hwua.entity.User;

import java.util.List;

public interface UserService {
    public User login(User user) throws Exception;//登录业务

    public boolean register(User user) throws Exception;//注册业务

    public List<User> getAllUsers() throws Exception;//获取所有的用户

    public User findUserById(Long id) throws Exception;//根据用户id查询用户信息
}
