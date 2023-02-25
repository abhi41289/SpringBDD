package org.oe.oemicroservices.controller;

import org.oe.oemicroservices.model.Address;
import org.oe.oemicroservices.model.Employee;
import org.oe.oemicroservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee employeeByID(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/AddEmployee")
    public List<Employee> postAddEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @PutMapping("/UpdateEmployee/{id}")
    public Employee updateEmployee( @PathVariable int id,@RequestBody Employee employee){

        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/DeleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);

    }

}

