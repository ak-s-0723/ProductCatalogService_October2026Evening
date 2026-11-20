package org.example.productcatalogservice_oct2026evening.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_oct2026evening.dtos.ProductDto;
import org.example.productcatalogservice_oct2026evening.models.Product;
import org.example.productcatalogservice_oct2026evening.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void TestGetProductByIdApi_WithUnavailableProductId_ReturnsNotFoundStatus() throws Exception {
        mockMvc.perform(get("/products/2"))    //Act
                .andExpect(status().isNotFound());        //Assert
    }


    @Test
    public void TestGetProductByIdApi_WithValidProductId_ReturnsOkStatus() throws Exception {
        //Arrange
        Product product = new Product();
        product.setId(2L);
        product.setName("Iphone");
        when(productService.getProductDetailsById(2L)).thenReturn(product);

        ProductDto expectedProductDto = new ProductDto();
        expectedProductDto.setId(2L);
       expectedProductDto.setName("Iphone");
       String expectedProductDtoString  = objectMapper.writeValueAsString(expectedProductDto);


        mockMvc.perform(get("/products/2"))    //Act
                .andExpect(status().isOk())     //Assert on Response Status
                .andExpect(content().string(expectedProductDtoString));    //Assert on Response body
    }
}
