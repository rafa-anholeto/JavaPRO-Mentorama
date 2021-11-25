package com.example.productAPI.services;

import com.example.productAPI.entities.Product;

public class TotalSaleCalculate {

    public static double saleTotalPriceProduct(Product product, Double maxDiscountPercentage, Integer maxInventoryQuantity) {
        Double productSale1 = product.getPriceWithDiscount(maxDiscountPercentage);
        Integer productSale2 = product.getTotalInventoryQuantity(maxInventoryQuantity);
        return productSale1 * productSale2;
    }

    public static Double saleTotalPrice(Double productOne, Double productTwo, Double productTree, Double productFour) {
        return productOne + productTwo + productTree + productFour;
    }
}
