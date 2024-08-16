package com.ems.EmployeeManagementSystem.controller;

import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import com.ems.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/bulk")
    public void saveAllEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveAllEmployees(employees);
    }
    @GetMapping("/search")
    public Page<Employee> searchEmployees(
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String departmentName,
            @RequestParam(required = false) Double salary,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {

        if (lastName != null) {
            return employeeService.getEmployeesByLastName(lastName, page, size, sortBy, sortOrder);
        } else if (departmentName != null) {
            return employeeService.getEmployeesByDepartment(departmentName, page, size, sortBy, sortOrder);
        } else if (salary != null) {
            return employeeService.getEmployeesBySalaryGreaterThan(salary, page, size, sortBy, sortOrder);
        } else if (minSalary != null && maxSalary != null) {
            return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary, page, size, sortBy, sortOrder);
        }

        return Page.empty(); // Return an empty page if no parameters are provided
    }
}
