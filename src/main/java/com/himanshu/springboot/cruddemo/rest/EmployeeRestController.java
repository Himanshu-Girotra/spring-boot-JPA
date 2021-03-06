package com.himanshu.springboot.cruddemo.rest;

import com.himanshu.springboot.cruddemo.entity.Employee;
import com.himanshu.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // quick solution : inject employee dao
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {

        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.FindByID(employeeId);
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tempEmployee = employeeService.FindByID(employeeId);
                if(tempEmployee== null)
                    throw new RuntimeException("Employee id not found-" + employeeId);
                    employeeService.deleteById(employeeId);
                    return "Deleted employee id -" + employeeId ;

    }

    @GetMapping("/employees1")
    public int count()
    {
        return employeeService.count();
    }


    @GetMapping("/employees_search")
    public Employee search()
    {
        return employeeService.search();
    }
}
