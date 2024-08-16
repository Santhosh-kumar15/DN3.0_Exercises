package com.ems.EmployeeManagementSystem.service;

import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployeesByLastName(String lastName, int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByLastName(lastName, pageable);
    }

    public Page<Employee> getEmployeesByDepartment(String departmentName, int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }

    public Page<Employee> getEmployeesBySalaryGreaterThan(Double salary, int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findBySalaryGreaterThan(salary, pageable);
    }

    public Page<Employee> getEmployeesByFirstNameAndDepartment(String firstName, String departmentName, int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByFirstNameAndDepartment(firstName, departmentName, pageable);
    }

    public Page<Employee> getEmployeesBySalaryRange(Double minSalary, Double maxSalary, int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findBySalaryRange(minSalary, maxSalary, pageable);
    }
}
