package com.merkleinc.interview.adapter;

import com.merkleinc.interview.model.Customer;
import com.merkleinc.interview.model.internal.CustomerApi;
import com.merkleinc.interviewkata.repository.CustomerRepository;
import com.merkleinc.interviewkata.repository.exception.RepositoryException;

public class CustomerAdapter implements CustomerApi {

    private final CustomerRepository customerRepository;
    private final CustomerTranslator customerTranslator;

    public CustomerAdapter() {
        this.customerRepository = new CustomerRepository();
        this.customerTranslator = new CustomerTranslator();
    }

    @Override
    public Customer getCustomer(String customerId) {
        try {
            return this.customerTranslator.translate(customerRepository.getCustomer(customerId));
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }
}
