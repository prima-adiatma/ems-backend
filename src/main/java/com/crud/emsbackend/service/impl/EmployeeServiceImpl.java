package com.crud.emsbackend.service.impl;

import com.crud.emsbackend.dto.EmployeeDto;
import com.crud.emsbackend.entity.Employee;
import com.crud.emsbackend.exception.ResourceNotFoundException;
import com.crud.emsbackend.mapper.EmployeeMapper;
import com.crud.emsbackend.repository.EmployeeRepository;
import com.crud.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // Before implementing the method, must create Inject Dependencies
    private EmployeeRepository employeeRepository;

    // Convert Employee DTO to Employee Entity because to store Employee Entity into Database
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // Convert Employee DTO to Employee Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Employee Entity saved into Database
        Employee savedEmployee = employeeRepository.save(employee);

        // Return convert savedEmployee JPA Entity into Employee DTO Entity
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given id" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) ->
                EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exist with given id" + employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updateEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exist with given id" + employeeId)
        );
        employeeRepository.deleteById(employeeId);

    }


}
