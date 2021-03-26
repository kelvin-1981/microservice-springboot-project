package com.yykj.springboot.service;

import com.yykj.springboot.dao.DepartmentDao;
import com.yykj.springboot.dao.IDepartmentDao;
import com.yykj.springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentDao  departmentDao;

    @Override
    public Collection<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public Department getDepartmentByID(Integer id) {
        return departmentDao.getDepartmentByID(id);
    }
}
