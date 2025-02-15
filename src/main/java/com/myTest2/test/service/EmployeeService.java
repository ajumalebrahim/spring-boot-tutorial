package com.myTest2.test.service;

import com.myTest2.test.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getAllEmployee();
    void updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
