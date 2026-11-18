package org.example.productcatalogservice_oct2026evening.repos;

import org.example.productcatalogservice_oct2026evening.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Query("SELECT c.name from Category  c where c.id=?1") //positional association
    //@Query("SELECT c.name from Category  c where c.id=:id") //named association
    String getCategoryNameById(Long id);
}


//void fn(int a, String b, bool c) {
//    ---
//}
//
//fn(1,"anurag",false); //postional
//fn(b = "anurag",a=2,c=true) //named