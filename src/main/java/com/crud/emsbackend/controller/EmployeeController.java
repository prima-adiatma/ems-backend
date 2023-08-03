package com.crud.emsbackend.controller;

import com.crud.emsbackend.dto.EmployeeDto;
import com.crud.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Add @RestController this class become a Spring REST Controller
// and this class capable to handle HTTP Request
@RestController
// Define the base URL for all the REST API
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API
    // @PostMapping to map the incoming HTTP POST Request to this method
    @PostMapping
    // @RequestBody will extract the JSON from the HTTP Request and
    // it will convert JSON into Employee Java Object
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // Build Get By ID Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto getIdEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(getIdEmployee);
    }

    // Build Get All Employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> getAllEmployeeDto = employeeService.getAllEmployee();
        return ResponseEntity.ok(getAllEmployeeDto);
    }

    // Build Update Employee REST API
    // @PutMapping("{id}") is template variable and need bind to this method argument
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updateEmployee) {
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(updatedEmployeeDto);
    }

    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!");
    }

}
