package com.example.productAPI.services;

import com.example.productAPI.entities.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalSaleCalculateTest {

    @Test
    public void calculateTotalSaleAmount(){

        Product p1 = new Product(1L,2.50,"Bolacha Bauduco",0.10,50);
        Product p2 = new Product(2L,8.50,"Desodorante Rexona",0.10,75);
        Product p3 = new Product(3L,12.50,"Café Terreiro",0.10,80);
        Product p4 = new Product(4L,10.00,"Coca-Cola",0.10,150);

        Double valor1 = TotalSaleCalculate.saleTotalPriceProduct(p1,0.0,2);
        assertEquals(valor1,5.0);


        Double valor2 = TotalSaleCalculate.saleTotalPriceProduct(p2,0.0,2);
        assertEquals(valor2,17);


        Double valor3 = TotalSaleCalculate.saleTotalPriceProduct(p3,0.0,2);
        assertEquals(valor3,25);


        Double valor4 = TotalSaleCalculate.saleTotalPriceProduct(p4,0.0,2);
        assertEquals(valor4,20);



        Double totalFinalPrice = TotalSaleCalculate.saleTotalPrice(valor1,valor2,valor3,valor4);
        assertEquals(totalFinalPrice,67);
    }

}