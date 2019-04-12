package com.merkleinc.interviewkata.application;

import com.merkleinc.interviewkata.repository.CustomerRepository;
import com.merkleinc.interviewkata.repository.exception.RepositoryException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CustomerDataService {
    private CustomerRepository customerRepository;

    public CustomerDataService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String customerId) throws RepositoryException {
        return map(customerRepository.getCustomer(customerId));
    }

    private Customer map(com.merkleinc.interviewkata.repository.model.Customer repositoryCustomer) {
        Customer customer = new Customer();
        customer.setFirstName(mapFirstName(repositoryCustomer.getName()));
        customer.setLastName(mapLastName(repositoryCustomer.getName()));
        customer.setMiddleName(mapMiddleName(repositoryCustomer.getName()));
        return customer;
    }

    private String mapFirstName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return StringUtils.substringBefore(name, " ").trim();
    }

    private String mapLastName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (name.split(" ").length < 2) {
            return null;
        }
        return StringUtils.substringAfterLast(name, " ").trim();
    }

    private String mapMiddleName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        if (name.split(" ").length < 3) {
            return null;
        }
        return StringUtils.substringBeforeLast(StringUtils.substringAfter(name, " ").trim(), " ");
    }


}
