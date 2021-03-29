package com.yykj.springboot.dao;

import com.yykj.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDao {

    public User queryUserByName(String name);
}
