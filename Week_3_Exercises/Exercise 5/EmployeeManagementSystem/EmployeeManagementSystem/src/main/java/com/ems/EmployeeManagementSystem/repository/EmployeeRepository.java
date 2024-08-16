package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Query methods using keywords
    List<Employee> findByLastName(String lastName);
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findBySalaryGreaterThan(Double salary);

    // Custom queries with @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.department.name = :departmentName")
    List<Employee> findByFirstNameAndDepartment(@Param("firstName") String firstName, @Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

    // Named queries execution
    @Query(name = "Employee.findByDepartment")
    List<Employee> findByDepartmentNameNamed(@Param("departmentName") String departmentName);

    @Query(name = "Employee.findByLastName")
    List<Employee> findByLastNameNamed(@Param("lastName") String lastName);
}
