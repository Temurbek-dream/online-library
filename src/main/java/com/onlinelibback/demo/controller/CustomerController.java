package com.onlinelibback.demo.controller;

import com.onlinelibback.demo.entity.Customer;
import com.onlinelibback.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<Customer> getStudents() {

        return customerRepository.findAll();

    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public String addCustomer(@RequestBody Customer customer) {

        customerRepository.save(customer);
        return "Added Customer : "+customer.getFullName();

    }

    @RequestMapping(method = RequestMethod.GET,value = "/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {

        return customerRepository.findById(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        customerRepository.deleteById(id);

        return "Record Deleted :"+ id;

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers")
    public String updateCustomer(@RequestBody Customer customer) {

        customerRepository.findById(customer.getId());

        if(customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
            return "Record updated";
        }
        else {
            return "No record";
        }


    }
}
