package com.yykj.springboot.controller;

import com.yykj.springboot.pojo.User;
import com.yykj.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> queryUserList() {
        List<User> userList = userService.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    //添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        userService.addUser(new User(10,"阿毛","123456"));
        return "success";
    }

    //修改一个用户
    @GetMapping("/updateUser")
    public String updateUser() {
        userService.updateUser(new User(10,"阿毛","123456"));
        return "success";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userService.deleteUser(10);
        return "success";
    }
}
