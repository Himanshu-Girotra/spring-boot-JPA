package com.himanshu.springboot.cruddemo.dao;

import com.himanshu.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //that's it
    @Query("SELECT COUNT(e) from Employee e ")
    int c();

    @Query("Select c from Employee c where c.firstname like 'Himanshu'")
    Employee result();



}