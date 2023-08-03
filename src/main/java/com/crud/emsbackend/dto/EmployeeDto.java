package com.crud.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// DTO Class is transfer the data between client and server
// DTO Class use as a response
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
