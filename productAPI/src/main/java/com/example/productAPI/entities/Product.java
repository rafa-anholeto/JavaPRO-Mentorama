package com.example.productAPI.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String name;
    private Double maxDiscountPercentage;
    private Integer maxInventoryQuantity;




    public Double getPriceWithDiscount(final Double discount){
        if(discount > maxDiscountPercentage){
            return price * (1 - maxDiscountPercentage);
        }
        else{
            return price * (1 - discount);
        }
    }

    public Integer getTotalInventoryQuantity(final Integer quantity) {
        if (quantity > maxInventoryQuantity) {
            String message = "Unavailable quantity";
            System.out.println(message +", Max quantity of product: "+ maxInventoryQuantity);
            return maxInventoryQuantity;
        } else {
            return quantity;
        }
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", maxDiscountPercentage=" + maxDiscountPercentage +
                ", maxInventoryQuantity=" + maxInventoryQuantity +
                '}';
    }
}
