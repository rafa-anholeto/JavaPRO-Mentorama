package com.example.productAPI.models;

import com.example.productAPI.entities.Product;
import org.junit.jupiter.api.Test;

class ListOfProductsTest {
    private Product product;

    @Test
    public void list(){
        ListOfProducts listOfProducts = new ListOfProducts(product);
        listOfProducts.list();
    }



}