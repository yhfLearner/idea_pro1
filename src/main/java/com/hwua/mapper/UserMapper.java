package com.hwua.mapper;

import com.hwua.entity.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public interface UserMapper {
    //插入用户
    public int insert(User user) throws SQLException;

    //查询用户
    public User queryByUser(User user) throws SQLException;

    //查询用户
    public User queryByName(String name) throws SQLException;

    //删除用户
    public int delete(Integer id) throws SQLException;

    //更新用户
    public int update(User user) throws SQLException;

    //查询所有的用户
    public List<User> queryAll() throws SQLException;

    //根据id查询用户
    public User queryById(Long id) throws SQLException;
}
