package com.yykj.springboot.service;

import com.yykj.springboot.dao.IUserDao;
import com.yykj.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public User queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }
}
