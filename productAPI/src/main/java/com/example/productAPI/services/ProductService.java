package com.example.productAPI.services;

import com.example.productAPI.entities.Product;
import com.example.productAPI.exceptions.BadRequestException;
import com.example.productAPI.mapper.ProductMapper;
import com.example.productAPI.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();

    }


    public Product findByIdOrThrowBadRequestException(long id){
        return productRepository.findById(id).orElseThrow(() -> new BadRequestException("Product not found"));
    }


    @Transactional
    public Product save(Product product) {

        return productRepository.save(ProductMapper.INSTANCE.toProduct(product));

    }

    public void delete(long id){
        productRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replaceProduct(Product product){

        Product savedProduct = findByIdOrThrowBadRequestException(product.getId());
        Product product1 = ProductMapper.INSTANCE.toProduct(product);
        product1.setId(savedProduct.getId());

        productRepository.save(product1);
    }


}
