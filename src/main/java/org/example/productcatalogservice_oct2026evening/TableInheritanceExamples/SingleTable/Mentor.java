package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="mentor_st")
@DiscriminatorValue(value = "MENTOR")
public class Mentor extends User {
    private Double ratings;
}
