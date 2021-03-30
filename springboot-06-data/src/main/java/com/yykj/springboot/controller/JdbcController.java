package com.yykj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public List<Map<String, Object>> getUserList(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list;
    }

    @GetMapping("/addUser")
    public String addUser(){
        jdbcTemplate.update("insert into user(id, name, pwd) values(10,'小明','123456')");
        return "success";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id){

        String sql = "update user set name  = ?,pwd = ? where id = " + id;

        // TODO: 参数对象
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "999999";

        jdbcTemplate.update(sql, objects);
        return "success";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        String sql = "delete from user where id = " + id;
        jdbcTemplate.update(sql);
        return "success";
    }
}
