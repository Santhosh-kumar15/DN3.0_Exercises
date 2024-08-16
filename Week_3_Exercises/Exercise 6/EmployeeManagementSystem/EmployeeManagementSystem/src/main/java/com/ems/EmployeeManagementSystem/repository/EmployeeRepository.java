package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method for pagination and sorting
    Page<Employee> findByLastName(String lastName, Pageable pageable);

    // Method for pagination and sorting by department
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    // Custom query with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    Page<Employee> findBySalaryGreaterThan(@Param("salary") Double salary, Pageable pageable);

    // Additional custom queries with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.department.name = :departmentName")
    Page<Employee> findByFirstNameAndDepartment(@Param("firstName") String firstName, @Param("departmentName") String departmentName, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    Page<Employee> findBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary, Pageable pageable);
}
