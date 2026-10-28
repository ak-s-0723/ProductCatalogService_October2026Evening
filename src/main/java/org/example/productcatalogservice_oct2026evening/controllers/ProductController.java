package org.example.productcatalogservice_oct2026evening.controllers;

import org.example.productcatalogservice_oct2026evening.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//object with singleton scope -> bean
//spring context
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone 18");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        return product;
    }

//    @GetMapping("/products/{pid}/users/{uid}")
//    public Product getProductBasedOnUser(@PathVariable("uid") Long userId,
//                                         @PathVariable("pid") Long productId) {}
}
