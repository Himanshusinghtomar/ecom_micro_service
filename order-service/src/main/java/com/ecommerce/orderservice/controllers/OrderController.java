package com.ecommerce.orderservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
class OrderController {

    @PostMapping
    public String placeOrder() {
        return "Order placed successfully!";
    }

    @GetMapping("/getOrders")
    public String getOrders() {
        return "Orders listed!";
    }

    private final RestTemplate restTemplate;

    @Value("${product-service.url}")
    private String productServiceUrl;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/{productName}")
    public String placeOrder(@PathVariable String productName) {
        // Call Product Service to check availability
        String url = productServiceUrl + "/products/" + productName + "/available";
        Boolean isAvailable = restTemplate.getForObject(url, Boolean.class);

        if (Boolean.TRUE.equals(isAvailable)) {
            return "Order placed for product: " + productName;
        } else {
            return "Product " + productName + " is not available.";
        }
    }
}

