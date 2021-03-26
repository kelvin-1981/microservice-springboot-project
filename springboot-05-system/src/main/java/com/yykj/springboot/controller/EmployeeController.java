package com.yykj.springboot.controller;

import com.yykj.springboot.pojo.Department;
import com.yykj.springboot.pojo.Employee;
import com.yykj.springboot.service.DepartmentService;
import com.yykj.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String getList(Model model){
        Collection<Employee> employees = employeeService.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmployeePage(Model model){
        Collection<Department> depts = departmentService.getDepartments();
        model.addAttribute("departments", depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee emp){
        employeeService.addEmployee(emp);
        return "redirect:/emps";
    }

    /**
     * Restful风格必须指定method 不能使用@RequestMapping
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/upemp/{id}")
    public String toUpdateEmpPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee emp){
        employeeService.addEmployee(emp);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
