package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="mentor_tpc")
public class Mentor extends User {
    private Double ratings;
}
