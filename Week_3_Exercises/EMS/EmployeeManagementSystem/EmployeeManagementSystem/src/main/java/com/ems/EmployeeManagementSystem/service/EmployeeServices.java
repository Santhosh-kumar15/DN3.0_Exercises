package com.ems.EmployeeManagementSystem.service;

import com.ems.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    void saveAllEmployees(List<Employee> employees);
}
