package com.yykj.springboot.service;

import com.yykj.springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
