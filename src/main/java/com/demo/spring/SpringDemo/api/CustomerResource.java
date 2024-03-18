package com.demo.spring.SpringDemo.api;

import com.demo.spring.SpringDemo.model.Customer;
import com.demo.spring.SpringDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;
    @PostMapping()
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }
}
