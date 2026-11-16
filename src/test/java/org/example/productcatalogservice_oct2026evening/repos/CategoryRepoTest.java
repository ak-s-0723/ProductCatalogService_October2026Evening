package org.example.productcatalogservice_oct2026evening.repos;

import org.example.productcatalogservice_oct2026evening.models.Category;
import org.example.productcatalogservice_oct2026evening.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes() {
        Optional<Category> categoryOptional = categoryRepo.findById(15L);
        Category category = categoryOptional.get();
        System.out.println(category.getName());
        for(Product product : category.getProducts()) {
            System.out.println(product.getName());
        }
    }

    @Test
    @Transactional
    public void testSomething() {
        for(Category category : categoryRepo.findAll()) {
            System.out.println(category.getName());
            for(Product product : category.getProducts()) {
                System.out.println(product.getName());
            }
        }
    }

}