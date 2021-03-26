package com.yykj.springboot.service;

import com.yykj.springboot.dao.EmployeeDao;
import com.yykj.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Collection<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
}
