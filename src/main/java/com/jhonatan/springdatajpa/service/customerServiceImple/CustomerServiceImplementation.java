package com.jhonatan.springdatajpa.service.customerServiceImple;

import com.jhonatan.springdatajpa.models.Customer;
import com.jhonatan.springdatajpa.repository.CustomerRepository;
import com.jhonatan.springdatajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation
        implements CustomerService {

    @Autowired
    private CustomerRepository repositoryCustomer;

    @Override
    public Customer saveCustomer(Customer customer) {
        return repositoryCustomer.save(customer);
    }
}
