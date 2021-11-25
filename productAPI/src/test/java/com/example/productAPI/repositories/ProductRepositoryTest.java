package com.example.productAPI.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {
    private ProductRepository productRepository;


    /*@Test
    public void shouldReturnAllProductsName(final String products){
        Product product = new Product(1,100.0, "TESTE", 0.10, 50);
        final List<Product> productss = new ArrayList<>();
        productss.add(product);

        final List<Product> result = productss.stream().filter(prod -> prod.getName().contains(products)).collect(Collectors.toList());
        Assertions.assertEquals(productss, result);

    }*/



}