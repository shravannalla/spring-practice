package com.shravan.springboot.thymeleafdemo.controller;

import com.shravan.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.shravan.springboot.thymeleafdemo.entity.Employee;
import com.shravan.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        Employee  theEmployee=new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel){
        //get the employee from the service
        Employee theEmployee=employeeService.findById(theId);

        //set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        //send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";

    }

}
