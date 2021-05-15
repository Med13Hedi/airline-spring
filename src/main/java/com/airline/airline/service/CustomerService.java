package com.airline.airline.service;

import com.airline.airline.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer findCustomerById(Long id);

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Long id);

}
