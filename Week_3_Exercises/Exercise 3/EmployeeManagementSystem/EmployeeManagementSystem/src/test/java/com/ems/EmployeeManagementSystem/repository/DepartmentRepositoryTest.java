package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Department;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional

public class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByName() {
        Department department = new Department();
        department.setName("IT");
        departmentRepository.save(department);

        Department foundDepartment = departmentRepository.findByName("IT").orElse(null);
        assertTrue(foundDepartment != null);
    }
}
