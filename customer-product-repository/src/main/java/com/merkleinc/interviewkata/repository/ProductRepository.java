package com.merkleinc.interviewkata.repository;

import java.util.List;
import com.merkleinc.interviewkata.repository.model.Product;
public interface ProductRepository {

    List<Product> getProducts();

    List<Product> getProducts(String partyId);
}
