package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="mentor_jc")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private Double ratings;
}
