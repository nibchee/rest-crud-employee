package com.geekynib.springboot.cruddemo.dao;

import com.geekynib.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.mapping.TypeDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{

    //define fields for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        //execute a query and get a result
        List<Employee> employees=theQuery.getResultList();

        //return the results
        return  employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //return employee
        return theEmployee;
    }

    //We don't use @Transactional here,handled at servce layer
    @Override
    public Employee save(Employee theEmployee) {
        //save the Employee
        //if id==0 then insert/save else update
        Employee dbEmployee=entityManager.merge(theEmployee);

        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee by id
        Employee theEmployee=entityManager.find(Employee.class,theId);
        //remove employee
        entityManager.remove(theEmployee);
    }
}
