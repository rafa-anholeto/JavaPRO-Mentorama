package com.example.productAPI.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void shouldCalculateTotalPriceWithDiscount(){
        Product product = new Product(4L,10.00,"Coca-Cola",0.10,150);
        Double result = product.getPriceWithDiscount(0.10);
        assertEquals(9.0, result);
    }

    @Test
    public void whenDiscountIsHigherThenMaxDiscountShouldUseMaxDiscountPercentage() {
        Product product = new Product(4L,10.00,"Coca-Cola",0.10,150);
        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(9.0, result);
    }

    @Test
    public void whenDiscountIsLowerThenMaxDiscountShouldUseProvidedDiscount() {
        Product product = new Product(4L,10.00,"Coca-Cola",0.10,150);
        Double result = product.getPriceWithDiscount(0.05);
        assertEquals(9.5, result);
    }

    @Test
    public void shouldCalculateStock() {
        Product product = new Product(4L,10.00,"Coca-Cola",0.10,150);
        Integer result = product.getTotalInventoryQuantity(180);
        assertEquals(150, result);
    }

}