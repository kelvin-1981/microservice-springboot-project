package com.yykj.springboot.service;

import com.yykj.springboot.pojo.Department;

import java.util.Collection;

public interface IDepartmentService {

    public Collection<Department> getDepartments();

    public Department getDepartmentByID(Integer id);
}
