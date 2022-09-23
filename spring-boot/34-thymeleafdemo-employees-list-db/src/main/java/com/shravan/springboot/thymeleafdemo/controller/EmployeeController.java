package com.shravan.springboot.thymeleafdemo.controller;

import com.shravan.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.shravan.springboot.thymeleafdemo.entity.Employee;
import com.shravan.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        List<Employee> theEmployees=employeeService.findAll();

        //add to the String model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
