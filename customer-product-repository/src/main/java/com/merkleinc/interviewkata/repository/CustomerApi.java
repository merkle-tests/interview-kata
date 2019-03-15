package com.merkleinc.interviewkata.repository;

import java.util.List;
import com.merkleinc.interviewkata.repository.model.Customer;
import com.merkleinc.interviewkata.repository.model.CustomerProduct;

public interface CustomerApi {

    Customer getCustomer(String customerId);

    List<CustomerProduct> getCustomerProducts();
    List<CustomerProduct> getCustomerProducts(String accountNumber);
}
