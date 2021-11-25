package com.example.productAPI.services;

import com.example.productAPI.models.ListOfProducts;
import com.example.productAPI.models.OrderItem;

public class OrderCalculator {
    public Double calculateOrder(final ListOfProducts listOfProducts){
        return listOfProducts.getProductsInStock().stream().mapToDouble(OrderItem::getPriceWithDiscount).sum();
    }
}
