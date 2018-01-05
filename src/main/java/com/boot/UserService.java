package com.boot;

import com.boot.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUserByName(String name);

    User queryById(Long id);

    List<User> queryAll();
    List<User> queryUserByPage(Integer page, Integer rows);

}
