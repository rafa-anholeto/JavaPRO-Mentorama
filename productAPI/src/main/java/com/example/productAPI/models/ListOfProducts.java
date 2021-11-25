package com.example.productAPI.models;

import com.example.productAPI.entities.Product;

import java.util.Arrays;
import java.util.List;


public class ListOfProducts {

    private final List<Product> productsInStock;

    public List<Product> getProductsInStock(){
        return productsInStock;
    }

    public ListOfProducts(Product product){
        this.productsInStock = Arrays.asList(new Product(1L,2.50,"Bolacha Bauduco",0.10,50),
                new Product(2L,8.50,"Desodorante Rexona",0.10,75),
                new Product(3L,12.50,"Café Terreiro",0.10,80),
                new Product(4L,10.00,"Coca-Cola",0.10,150));
    }

    public void list(){
        for(Product list: productsInStock){
            System.out.println(list);
        }
    }
}
