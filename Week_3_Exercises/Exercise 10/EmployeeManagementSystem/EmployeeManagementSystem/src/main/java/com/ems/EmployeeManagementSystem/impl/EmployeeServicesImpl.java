package com.ems.EmployeeManagementSystem.impl;

import com.ems.EmployeeManagementSystem.entity.Employee;
import com.ems.EmployeeManagementSystem.service.EmployeeServices;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServicesImpl implements EmployeeServices {
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public void saveAllEmployees(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % 20 == 0) { // Flush and clear the batch every 20 inserts
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
