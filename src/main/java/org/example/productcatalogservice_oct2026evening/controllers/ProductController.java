package org.example.productcatalogservice_oct2026evening.controllers;

import org.example.productcatalogservice_oct2026evening.dtos.CategoryDto;
import org.example.productcatalogservice_oct2026evening.dtos.ProductDto;
import org.example.productcatalogservice_oct2026evening.models.Product;
import org.example.productcatalogservice_oct2026evening.services.IProductService;
import org.example.productcatalogservice_oct2026evening.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//object with singleton scope -> bean
//spring context
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;



    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Iphone 18");
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        return products;
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
//        Product product = new Product();
//        product.setId(productId);
//        return product;
        Product product = productService.getProductDetailsById(productId);
        if(product == null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        ProductDto productDto = from(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setDescription(product.getCategory().getDescription());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

//    @GetMapping("/products/{pid}/users/{uid}")
//    public Product getProductBasedOnUser(@PathVariable("uid") Long userId,
//                                         @PathVariable("pid") Long productId) {}
}
