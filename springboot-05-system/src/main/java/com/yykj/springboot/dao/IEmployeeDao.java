package com.yykj.springboot.dao;

import com.yykj.springboot.pojo.Employee;

import java.util.Collection;

public interface IEmployeeDao {

    public void addEmployee(Employee employee);

    //查询全部的员工信息
    public Collection<Employee> getAll();

    //通过ID查询员工
    public Employee getEmployeeById(Integer id);

    //通过ID删除员工
    public void delete(Integer id);
}
