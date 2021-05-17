package com.airline.airline.controller;

import com.airline.airline.model.Customer;
import com.airline.airline.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.findCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customerDetails){
        Customer customer = customerService.findCustomerById(id);

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setDob(customerDetails.getDob());
        customer.setPhone(customerDetails.getPhone());
        customer.setCountry(customerDetails.getCountry());

        customerService.updateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
