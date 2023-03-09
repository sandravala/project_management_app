package com.pm.finalproject.drafts.budget.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@Entity
@Table(name="BUDGET")
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @Column(name="BUDGET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="COST_NAME")
    private String costName;

    @Column(name="ELIGIBLE_COST_AMOUNT")
    private BigDecimal eligibleCostAmount;

    @Column(name="CONTRACT_COST")
    private BigDecimal contractCost;

    @Column(name="DECLARED_AMOUNT")
    private BigDecimal declaredAmount;



    // investicijos pavadinimas
    //tfi planas
    //tfi faktas (pagal sutarti)
    //tfi deklaruota (pagal mp)
    //finansavimo planas
    //finansavimo ismoketa
    //finansavimo likutis
    //tfi liktuis
    //sutaupymai
    //MP (kuriuose ir kiek deklaruota)
    //SUTARTYS
}
