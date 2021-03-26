package com.yykj.springboot.service;

import com.yykj.springboot.pojo.Employee;

import java.util.Collection;
import java.util.List;

public interface IEmployeeService {

    //查询全部的员工信息
    public Collection<Employee> getAll();

    //通过ID查询员工
    public Employee getEmployeeById(Integer id);

    public void addEmployee(Employee employee);

    //通过ID删除员工
    public void delete(Integer id);
}
