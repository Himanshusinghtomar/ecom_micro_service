package com.ecommerce.productservice.controllers;


import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
class ProductControllers {

    private static List<String> products = Arrays.asList("Laptop", "Phone", "Tablet","Hatchback","Notebook");

    @GetMapping
    public List<String> getProducts() {
        return products;
    }

    @GetMapping("/{productName}/available")
    public boolean isProductAvailable(@PathVariable String productName) {
        return products.contains(productName);
    }
}
