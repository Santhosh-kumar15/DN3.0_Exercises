package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
