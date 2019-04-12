package com.merkleinc.interviewkata.application;

import com.merkleinc.interviewkata.repository.model.Address;
import com.merkleinc.interviewkata.repository.model.Customer;

public class CustomerBuilder {


    private final String id;
    private String name;
    private String gender;
    private String birthday;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private Address address;

    public CustomerBuilder(String id) {
        this.id = id;
    }

    public static CustomerBuilder aCustomer(String id){
        return new CustomerBuilder(id);
    }


    public CustomerBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Customer build(){
        return new Customer(
                id,
                name,
                gender,
                birthday,
                email,
                phoneNumber,
                accountNumber,
                address
        );
    }
}
