package org.example.productcatalogservice_oct2026evening.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice_oct2026evening.models.Category;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDto category;
}
