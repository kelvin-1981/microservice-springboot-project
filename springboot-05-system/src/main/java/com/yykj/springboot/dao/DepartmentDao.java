package com.yykj.springboot.dao;

import com.yykj.springboot.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao implements IDepartmentDao{

    private static Map<Integer, Department> departments;
    //模拟数据
    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "后勤部"));
    }

    @Override
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    @Override
    public Department getDepartmentByID(Integer id) {
        return departments.get(id);
    }
}
