package com.example.productAPI.controllers;

import com.example.productAPI.entities.Product;
import com.example.productAPI.requests.ProductPutRequestBody;
import com.example.productAPI.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>((productService.findAll()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity(productService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity<>((HttpStatus.NO_CONTENT));
    }

    @PutMapping
    public ResponseEntity<PostMapping> replaceProduct(@RequestBody ProductPutRequestBody productPutRequestBody){
        productService.replaceProduct(productPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
