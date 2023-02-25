package org.oe.oemicroservices.service;

import org.oe.oemicroservices.model.Address;
import org.oe.oemicroservices.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {


    private List<Employee> employeeLists = new ArrayList<>(List.of(
            Employee.builder().id(1)
                    .name("abhishekRajP")
                    .address(Address.builder().city("Hyderabad").street("India").country("Eseva Lane").build())
                    .email("abhishek@test.com")
                    .phone(12345).build(),
            Employee.builder().id(2)
                    .name("Lizzy")
                    .address(Address.builder().city("Hyderabad").street("India").country("Eseva Lane").build())
                    .email("Lizzy@test.com")
                    .phone(54321).build()
    ));

    public List<Employee> getAllEmployees() {
        return employeeLists;

    }

    public Employee getEmployeeById(int id) {
        return employeeLists.stream()
                .filter(x -> x.getId() == id)
                .findFirst().get();
    }

    public List<Employee> addEmployee(Employee employee) {

        employeeLists.add(employee);
        return employeeLists;
    }

    public Employee updateEmployee(int id,  Employee employee) {

        return employeeLists.stream()
                .filter(x -> x.getId() == id)
                .peek(o -> o.setName(employee.getName()))
                .peek(o -> o.setEmail(employee.getEmail()))
                .peek(o -> o.setPhone(employee.getPhone()))
                .findFirst().get();
    }


    public List<Employee> deleteEmployee(int id) {


        employeeLists.removeIf(x -> x.getId() == id);

        return employeeLists;


    }
}
