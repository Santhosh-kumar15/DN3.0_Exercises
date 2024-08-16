package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Department;
import com.ems.EmployeeManagementSystem.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional

public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName() {
        Department department = new Department();
        department.setName("HR");
        department = departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment(department);
        employeeRepository.save(employee);

        List<Employee> employees = employeeRepository.findByName("John Doe");
        assertNotNull(employees);
    }
}
