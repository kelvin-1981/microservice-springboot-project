package com.yykj.springboot.dao;

import com.yykj.springboot.pojo.Department;

import java.util.Collection;

public interface IDepartmentDao {

    public Collection<Department> getDepartments();

    public Department getDepartmentByID(Integer id);
}
