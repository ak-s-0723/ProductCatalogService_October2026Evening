package org.example.productcatalogservice_oct2026evening.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="ta_st")
@DiscriminatorValue(value = "TA")
public class Ta extends User {
    private Long numOfHours;
}

