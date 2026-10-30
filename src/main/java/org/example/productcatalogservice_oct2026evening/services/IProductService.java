package org.example.productcatalogservice_oct2026evening.services;

import org.example.productcatalogservice_oct2026evening.models.Product;

public interface IProductService {

    Product getProductDetailsById(Long id);
}
