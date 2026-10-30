package org.example.productcatalogservice_oct2026evening.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {
    private String name;
    private String description;
    private Long id;
}
