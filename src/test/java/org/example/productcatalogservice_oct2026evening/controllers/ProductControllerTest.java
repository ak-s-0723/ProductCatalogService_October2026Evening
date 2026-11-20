package org.example.productcatalogservice_oct2026evening.controllers;

import org.example.productcatalogservice_oct2026evening.dtos.ProductDto;
import org.example.productcatalogservice_oct2026evening.models.Product;
import org.example.productcatalogservice_oct2026evening.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void TestGetProductById_WithValidProductId_ReturnsProductSuccessfully() {
        //Arrange
        Long id = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("Iphone");
       when(productService.getProductDetailsById(id)).thenReturn(product);

        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductById(id);

        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(id, productDtoResponseEntity.getBody().getId());
        assertEquals("Iphone", productDtoResponseEntity.getBody().getName());
    }


    @Test
    public void TestGetProductById_WithNegativeProductId_ResultsInIllegalArgumentException() {
        //Arrange
        Long id = -2L;

        //Act and Assert
        Exception exception =
                assertThrows(IllegalArgumentException.class,
                () -> productController.getProductById(id));

        assertEquals("Invalid Id", exception.getMessage());
    }

    @Test
    public void TestGetProductById_WithUnavailableProductId_ResultsInRunTimeException() {
        assertThrows(RuntimeException.class,
                ()-> productController.getProductById(100L));
    }

}