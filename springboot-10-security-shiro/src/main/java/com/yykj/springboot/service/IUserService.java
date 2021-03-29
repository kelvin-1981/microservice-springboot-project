package com.yykj.springboot.service;

import com.yykj.springboot.pojo.User;

public interface IUserService {

    public User queryUserByName(String name);
}
