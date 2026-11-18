package org.example.productcatalogservice_oct2026evening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    //@BatchSize(size = 3)
    private List<Product> products;
}


//1 from category + 6 from Product
//        batch size = 3
//        1 + 2  =  3
//       batch size = 1
//        1 + 6 = 7
//       batch size  =10
//         1+1 = 2