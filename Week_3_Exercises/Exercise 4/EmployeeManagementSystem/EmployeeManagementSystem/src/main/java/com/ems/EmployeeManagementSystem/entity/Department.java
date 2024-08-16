package com.ems.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

    // Constructors, Getters, Setters
    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setDepartment(this);
    }
}
