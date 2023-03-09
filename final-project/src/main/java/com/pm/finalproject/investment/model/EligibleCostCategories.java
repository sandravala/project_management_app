package com.pm.finalproject.investment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name="ELIGIBLE_COST_CATEGORIES")
@NoArgsConstructor
@AllArgsConstructor
public class EligibleCostCategories {

    @Id
    @Column(name="ELIGIBLE_COST_CATEGORIES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NUMBER")
    private String number;

    @Column(name="NAME")
    private String name;

}
