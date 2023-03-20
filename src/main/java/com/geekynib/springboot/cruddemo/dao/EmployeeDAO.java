package com.geekynib.springboot.cruddemo.dao;

import com.geekynib.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
