package org.example.productcatalogservice_oct2026evening.controllers;

import org.example.productcatalogservice_oct2026evening.dtos.CategoryDto;
import org.example.productcatalogservice_oct2026evening.dtos.ProductDto;
import org.example.productcatalogservice_oct2026evening.models.Category;
import org.example.productcatalogservice_oct2026evening.models.Product;
import org.example.productcatalogservice_oct2026evening.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//object with singleton scope -> bean
//spring context
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Iphone 18");
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        return products;
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        if(productId <= 0L) {
            throw new IllegalArgumentException("Please pass productId > 0");
        }

        Product product = productService.getProductDetailsById(productId);
        if(product == null) {
            //return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            throw new RuntimeException("Product is not available");
        }

        ProductDto productDto = from(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ProductDto replaceProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
       Product inputProduct =  from(productDto);
       Product outputProduct = productService.replaceProduct(id,inputProduct);
       if (outputProduct == null) return null;
       return from(outputProduct);
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            product.setCategory(category);
        }
        return product;
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
