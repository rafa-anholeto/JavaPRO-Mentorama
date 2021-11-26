package com.example.productAPI.models;

import com.example.productAPI.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderItemTest {

    @Test
    public void shouldCalculateTotalPrice(){
        Product product = new Product(4L,10.00,"Coca-Cola",0.50,150);
        OrderItem orderItem = new OrderItem(product,3,0.0);
        final Double result = orderItem.getPriceWithDiscount();
        Assertions.assertEquals(30, result);
    }



}