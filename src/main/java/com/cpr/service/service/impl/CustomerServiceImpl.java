package com.cpr.service.service.impl;

import com.cpr.service.model.Customer;
import com.cpr.repository.CustomerRepository;
import com.cpr.service.response.KpiResponse;
import com.cpr.service.service.CustomerService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() != null && customerRepository.findById(customer.getId()).isPresent()) {
            customerRepository.save(customer);
        } else {
            customerRepository.save(customer);
        }
    }

    @Override
    public List<Customer> findBy(@Nullable String dni, @Nullable String email) {
        Customer c = new Customer();
        c.setEmail(email);
        c.setDni(dni);
        customerRepository.findAll(Example.of(c));
        return customerRepository.findAll(Example.of(c));
    }

    @Override
    public KpiResponse getkpi() {
        List<Customer> listCustomer = customerRepository.findAll();
        IntSummaryStatistics summaryStatistics = listCustomer.stream()
                .map(Customer::calculateAge)
                .mapToInt((x) -> x)
                .summaryStatistics();

        //kpis
        KpiResponse response = new KpiResponse();
        response.setAverage((int) summaryStatistics.getAverage());
        response.setMaximunEdge(summaryStatistics.getMax());
        response.setMinumEdge(summaryStatistics.getMin());
        response.setCustomerMaximunEdge(Collections.max(listCustomer, Comparator.comparing(Customer::calculateAge)));
        response.setCustomerMinumEdge(Collections.min(listCustomer, Comparator.comparing(Customer::calculateAge)));
        return response;
    }

}
