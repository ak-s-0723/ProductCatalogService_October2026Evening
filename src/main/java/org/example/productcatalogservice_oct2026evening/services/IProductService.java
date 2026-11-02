package org.example.productcatalogservice_oct2026evening.services;

import org.example.productcatalogservice_oct2026evening.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductDetailsById(Long id);

    Product replaceProduct(Long id,Product inputProduct);

    List<Product> getAllProducts();
}
