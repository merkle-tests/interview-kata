package com.merkleinc.interviewkata.repository;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.merkleinc.interviewkata.repository.model.Customer;

public class CustomerRepositoryTest {

    @Test
    public void setUp() throws IOException {

        CustomerRepository testee = new CustomerRepository();

        Customer customer = testee.getCustomer("1");

        Assert.assertNotNull(customer);
    }
}
