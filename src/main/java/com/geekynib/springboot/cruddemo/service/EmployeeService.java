package com.geekynib.springboot.cruddemo.service;

import com.geekynib.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
