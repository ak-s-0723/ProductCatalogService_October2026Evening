package org.example.productcatalogservice_oct2026evening.repos;

import org.example.productcatalogservice_oct2026evening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
