package com.example.productAPI.services;

import com.example.productAPI.entities.Product;
import com.example.productAPI.exceptions.BadRequestException;
import com.example.productAPI.mapper.ProductMapper;
import com.example.productAPI.repositories.ProductRepository;
import com.example.productAPI.requests.ProductPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private List<Product> productsList;
    private List<Product> productsInStock;




    public List<Product> findAll() {
        return productRepository.findAll();

    }


    public Product findByIdOrThrowBadRequestException(long id){
        return productRepository.findById(id).orElseThrow(() -> new BadRequestException("Product not found"));
    }


    public Product save(Product product) {
        /*product.setId(ThreadLocalRandom.current().nextLong(3,10000));*/
       /*if(productsList.stream().anyMatch(prod -> prod.getName().equals(prod.getName()))){
           throw new sameNameException();
       }*/

        return productRepository.save(ProductMapper.INSTANCE.toProduct(product));

    }

    public void delete(long id){
        productRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replaceProduct(ProductPutRequestBody productPutRequestBody){
        //delete(product.getId());
        Product savedProduct = findByIdOrThrowBadRequestException(productPutRequestBody.getId());
        Product product = ProductMapper.INSTANCE.toProduct(productPutRequestBody);
        product.setId(savedProduct.getId());

        productRepository.save(product);
    }


}
