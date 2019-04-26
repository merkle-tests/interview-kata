package com.merkleinc.interview.model;

public enum Gender {

    MALE("M"),
    FEMALE("F"),
    UNESPECIFIED("X");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
