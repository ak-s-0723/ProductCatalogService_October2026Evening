package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="ta_jc")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User {
    private Long numOfHours;
}

