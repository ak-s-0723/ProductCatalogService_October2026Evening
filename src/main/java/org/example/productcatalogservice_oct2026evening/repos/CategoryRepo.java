package org.example.productcatalogservice_oct2026evening.repos;

import org.example.productcatalogservice_oct2026evening.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
