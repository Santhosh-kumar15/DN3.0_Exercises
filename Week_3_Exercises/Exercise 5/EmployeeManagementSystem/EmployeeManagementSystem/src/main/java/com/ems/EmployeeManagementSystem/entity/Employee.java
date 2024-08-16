package com.ems.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "Employee.findByDepartment",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"),
        @NamedQuery(name = "Employee.findByLastName",
                query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Constructors, Getters, Setters
    public Employee() {
    }

    public Employee(String name, String email, Department department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

}
