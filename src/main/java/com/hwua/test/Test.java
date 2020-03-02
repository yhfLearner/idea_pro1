package com.hwua.test;

import com.hwua.entity.User;
import com.hwua.service.UserService;
import com.hwua.service.impl.UserServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        UserService us = new UserServiceImpl();
        /*User user = new User();
        user.setName("哈哈");
        user.setPwd("234567");
        user.setEmail("234567@qq.com");
        boolean bool = us.register(user);
        System.out.println(bool);*/
        List<User> uList = us.getAllUsers();
        System.out.println(uList);

    }
}
