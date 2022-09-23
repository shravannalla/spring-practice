package springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springdemo.dao.CustomerDAO;
import springdemo.entity.Customer;


import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject our customer service
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String listCustomers(Model theModel){

        //get customers from service
        List<Customer> theCustomers=customerDAO.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

//    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model theModel){
//
//    }

}
