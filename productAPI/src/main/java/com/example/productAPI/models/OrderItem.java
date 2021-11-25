package com.example.productAPI.models;

import com.example.productAPI.entities.Product;

public class OrderItem {

    private static Product product;
    private static Integer maxInventoryQuantity;
    private static Double maxDiscountPercentage;

    public OrderItem(Product product, Integer maxInventoryQuantity, Double maxDiscountPercentage) {
        OrderItem.product = product;
        OrderItem.maxInventoryQuantity = maxInventoryQuantity;
        OrderItem.maxDiscountPercentage = maxDiscountPercentage;
    }

    public double getTotalInventoryQuantity(){
        return product.getTotalInventoryQuantity(maxInventoryQuantity);
    }

    public  double getPriceWithDiscount() {
        return product.getPriceWithDiscount(maxDiscountPercentage) * maxInventoryQuantity;
    }

    public static double getPriceWithDiscount(Product product) {
        return 0;
    }

}
