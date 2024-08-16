package com.ems.EmployeeManagementSystem.projection;

public class EmployeeNameAndSalary {
    private final String firstName;
    private final String lastName;
    private final Double salary;

    public EmployeeNameAndSalary(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

}
