package com.cydeo.employeeregistrationproject.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter //we need getter and setters for thymeleaf
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  //this is needed for thymeleaf to do the age calculation
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
