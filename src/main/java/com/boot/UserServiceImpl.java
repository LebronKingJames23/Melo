package com.boot;

import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public User queryById(Long id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryAll() {
        List<User> list = this.userMapper.queryAll();
        return list;

    }

    @Override
    public List<User> queryUserByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        // 使用通用Mapper的方法进行查询所有数据
        List<User> list = this.userMapper.select(null);
        return list;

    }
}
