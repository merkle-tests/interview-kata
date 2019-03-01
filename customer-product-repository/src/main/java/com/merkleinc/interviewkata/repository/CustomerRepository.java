package com.merkleinc.interviewkata.repository;

import com.merkleinc.interviewkata.repository.model.Customer;
public interface CustomerRepository {

    Customer getCustomer(String id);
}
