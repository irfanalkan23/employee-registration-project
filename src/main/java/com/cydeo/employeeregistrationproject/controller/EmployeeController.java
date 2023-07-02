package com.cydeo.employeeregistrationproject.controller;

import com.cydeo.employeeregistrationproject.bootstrap.DataGenerator;
import com.cydeo.employeeregistrationproject.model.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        // @ModelAttribute : captures the employee object from UI (employee-list.html)
        // BindingResult interface: must be right after the object we validate!!!

        // iot stop the execution and staying at the same page and show error messages
        // it will wait until the user fills the entire form
        if (bindingResult.hasErrors()){

            model.addAttribute("states", DataGenerator.getAllStates()); // in order not to lose the selected State
            return "employee/employee-create";
        }

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());
        return "employee/employee-list";
    }
}





