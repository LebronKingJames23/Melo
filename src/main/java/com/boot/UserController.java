package com.boot;

import com.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("user")
    public class UserController {
        @Autowired
        private UserService userService;
        @RequestMapping("list/{name}")
        public List<User> listUser(@PathVariable String name) {
            List<User> list = userService.findUserByName(name);
            return list;
        }
        @RequestMapping("queryById/{id}")
        public User queryById(@PathVariable Long id){
           User user= userService.queryById(id);
           return user;
        }
        @RequestMapping("list")
        public List<User> queryAll() {
            List<User> list = this.userService.queryAll();
            return list;
        }

        @RequestMapping("list/{page}/{rows}")
        public List<User> queryUserAll(@PathVariable Integer page, @PathVariable Integer rows) {
            List<User> list = this.userService.queryUserByPage(page, rows);
            return list;
        }


    }
