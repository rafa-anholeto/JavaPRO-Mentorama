package com.example.productAPI.mapper;

import com.example.productAPI.entities.Product;
import com.example.productAPI.requests.ProductPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract Product toProduct(Product product);
    public abstract Product toProduct(ProductPutRequestBody productPutRequestBody);


}
