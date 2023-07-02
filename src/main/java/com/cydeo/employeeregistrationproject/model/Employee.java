package com.cydeo.employeeregistrationproject.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter //we need getter and setters for thymeleaf
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

//    @NotNull    // " " "" --> accepted
//    @NotEmpty   // " " --> accepted. Not trims.
//    @NotBlank   // "" " " null --> these are NOT accepted. Trims the String and checks if any character left

    @NotBlank
    @Size(max = 12, min = 2)
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
