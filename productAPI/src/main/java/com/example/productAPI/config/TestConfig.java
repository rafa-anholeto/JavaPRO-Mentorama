package com.example.productAPI.config;

import com.example.productAPI.entities.Product;
import com.example.productAPI.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public void run(String... args) throws Exception {
        Product p1 = new Product(1L,2.50,"Bolacha Bauduco",0.10,50);
        Product p2 = new Product(2L,8.50,"Desodorante Rexona",0.10,75);
        Product p3 = new Product(3L,12.50,"Café Terreiro",0.10,80);
        Product p4 = new Product(4L,10.00,"Coca-Cola",0.10,150);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));




    }

}

