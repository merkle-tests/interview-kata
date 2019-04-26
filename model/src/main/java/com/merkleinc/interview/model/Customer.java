package com.merkleinc.interview.model;

import org.joda.time.DateTime;

public class Customer {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Gender gender;
    private final DateTime birthday;
    private final int age;
    private final String address;
    private final String phoneNumber;
    private final String email;

    private Customer(String firstName, String middleName, String lastName, Gender gender, DateTime birthday, int age, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
