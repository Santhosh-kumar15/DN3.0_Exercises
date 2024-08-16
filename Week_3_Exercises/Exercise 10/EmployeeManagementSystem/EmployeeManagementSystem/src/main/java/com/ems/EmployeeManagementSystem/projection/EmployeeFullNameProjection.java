package com.ems.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeFullNameProjection {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    String getDepartmentName();
}
