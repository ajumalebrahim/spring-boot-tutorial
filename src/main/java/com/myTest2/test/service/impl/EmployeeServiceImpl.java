package com.myTest2.test.service.impl;

import com.myTest2.test.dto.EmployeeDto;
import com.myTest2.test.entity.Employee;
import com.myTest2.test.exception.ResourceNotFound;
import com.myTest2.test.mapper.EmployeeMapper;
import com.myTest2.test.repository.EmployeeRepository;
import com.myTest2.test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found with id: "+ id));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::maptoEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found with id: "+ id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found with id: "+ id));
        employeeRepository.delete(employee);
    }
}
