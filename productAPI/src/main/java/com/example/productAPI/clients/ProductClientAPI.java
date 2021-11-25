package com.example.productAPI.clients;

import com.example.productAPI.entities.Product;

import java.util.List;

public class ProductClientAPI {

    private List<Product> products;

    public List<Product> findAll() {
        return this.products;
    }
}
