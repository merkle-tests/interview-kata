package com.merkleinc.interviewkata.repository;

import java.io.IOException;
import java.io.InputStreamReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

class FileReader<T> {

    public static <T> T getParsedValues(String file) {
        try {
            return new ObjectMapper().readValue(
                    new InputStreamReader(CustomerRepository.class.
                            getResourceAsStream(file)),
                    new TypeReference<T>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //public static FileReader aFileReaderFor(Class clazz){
    //    return new FileReader<>();
    //}
}
