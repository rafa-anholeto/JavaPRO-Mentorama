package com.example.productAPI.requests;

import lombok.Data;

@Data
public class ProductPutRequestBody {
    private Long id;
    private Double price;
    private String name;
    private Double maxDiscountPercentage;
    private Integer maxInventoryQuantity;

}
