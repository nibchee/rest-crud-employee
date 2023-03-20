package com.geekynib.springboot.cruddemo.rest;

import com.geekynib.springboot.cruddemo.dao.EmployeeDAO;
import com.geekynib.springboot.cruddemo.entity.Employee;
import com.geekynib.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    //quick and dirty :inject employee dao using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //expose "/employees" & return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
