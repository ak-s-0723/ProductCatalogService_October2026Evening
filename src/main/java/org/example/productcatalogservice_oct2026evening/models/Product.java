package org.example.productcatalogservice_oct2026evening.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
    private Double commission; //sensitive
    private Boolean isPrimeSaleSpecific; //sensitive
}
