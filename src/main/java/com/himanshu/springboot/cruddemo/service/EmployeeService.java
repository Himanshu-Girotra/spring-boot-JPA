package com.himanshu.springboot.cruddemo.service;

import com.himanshu.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee FindByID(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

    public int count();

    public Employee search();
}
