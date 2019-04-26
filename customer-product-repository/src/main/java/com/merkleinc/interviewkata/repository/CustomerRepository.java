package com.merkleinc.interviewkata.repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.merkleinc.interviewkata.repository.exception.RepositoryException;
import com.merkleinc.interviewkata.repository.model.Customer;
import com.merkleinc.interviewkata.repository.model.CustomerProduct;

public class CustomerRepository implements CustomerApi {

    private final List<Customer> customers;
    private final List<CustomerProduct> customerProducts;

    public CustomerRepository() {

        this.customers = Collections.unmodifiableList(new FileReader().<List<Customer>>getParsedValues("/customer/customers.json"));
        this.customerProducts = Collections.unmodifiableList(new FileReader().<List<CustomerProduct>>getParsedValues("/customer/customerProducts.json"));
    }

    @Override
    public Customer getCustomer(String customerId) throws RepositoryException {
        return customers.stream()
                .filter(e -> customerId.equals(e.getId()))
                .findFirst()
                .orElseThrow(() -> new RepositoryException("Customer not found"));
    }

    @Override
    public List<CustomerProduct> getCustomerProducts() {
        return customerProducts;
    }

    @Override
    public List<CustomerProduct> getCustomerProducts(String accountNumber) throws RepositoryException {
        Customer customer = customers.stream()
                .filter(e -> accountNumber.equals(e.getAccountNumber()))
                .findFirst()
                .orElseThrow(() -> new RepositoryException("Customer not found"));

        return getCustomerProducts().stream()
                .filter(e -> customer.getId().equals(e.getCustomerId()))
                .collect(Collectors.toList());
    }
}
