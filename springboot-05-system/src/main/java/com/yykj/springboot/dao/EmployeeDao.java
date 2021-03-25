package com.yykj.springboot.dao;

import com.yykj.springboot.pojo.Department;
import com.yykj.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao implements IEmployeeDao{

    private static Map<Integer, Employee> employees;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "2921625927@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "4534545434@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "7767546755@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "7654788797@qq.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "4343546768@qq.com", 1, new Department(105, "后勤部")));
    }

    //主键自增加
    private static Integer initId = 1006;

    @Override
    public void addEmployee(Employee employee) {
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentByID(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    @Override
    public void delete(Integer id) {
        employees.remove(id);
    }
}
