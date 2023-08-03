package com.crud.emsbackend.mapper;

import com.crud.emsbackend.dto.EmployeeDto;
import com.crud.emsbackend.entity.Employee;

public class EmployeeMapper {

    // Convert Employee JPA Entity into Employee DTO Entity
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Convert Employee DTO Entity into Employee JPA Entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
