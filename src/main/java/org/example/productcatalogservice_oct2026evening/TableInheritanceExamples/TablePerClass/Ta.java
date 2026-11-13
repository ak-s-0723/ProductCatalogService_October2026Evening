package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="ta_tpc")
public class Ta extends User {
    private Long numOfHours;
}

