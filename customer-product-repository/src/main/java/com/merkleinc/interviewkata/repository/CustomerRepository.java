package com.merkleinc.interviewkata.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merkleinc.interviewkata.repository.model.Customer;
import com.merkleinc.interviewkata.repository.model.CustomerProduct;
public class CustomerRepository implements CustomerApi {

    private final List<Customer> customers;

    private final List<CustomerProduct> customerProducts;

    public CustomerRepository() throws IOException {

        this.customers = Collections.unmodifiableList(
                new ObjectMapper().readValue(
                        new InputStreamReader(CustomerRepository.class.
                                getResourceAsStream("/customer/customers.json")),
                        new TypeReference<List<Customer>>() {
                        }));

        this.customerProducts = Collections.unmodifiableList(
                new ObjectMapper().readValue(
                        new InputStreamReader(CustomerRepository.class.
                                getResourceAsStream("/customer/customerProducts.json")),
                        new TypeReference<List<CustomerProduct>>() {
                        }));
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customers.stream()
                .filter(e -> customerId.equals(e.getId()))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public List<CustomerProduct> getCustomerProducts() {
        return customerProducts;
    }

    @Override
    public List<CustomerProduct> getCustomerProducts(String accountNumber) {
        return null;
    }
}
