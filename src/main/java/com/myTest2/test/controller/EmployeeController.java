package com.myTest2.test.controller;

import com.myTest2.test.dto.EmployeeDto;
import com.myTest2.test.entity.Employee;
import com.myTest2.test.service.EmployeeService;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>("Added Success", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody EmployeeDto employeeDto) {
         employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Remove Success");
    }

}
