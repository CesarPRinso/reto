package com.cpr.service.service;


import com.cpr.service.model.Customer;
import com.cpr.service.response.KpiResponse;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);
    List<Customer> findBy(String dni, String email);
    KpiResponse getkpi();
}
