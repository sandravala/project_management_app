package com.pm.finalproject.projects.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Data
@Entity
@Table(name="PROJECT")
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="PROJECT_NUMBER")
    private String projectNo;

    @Column(name="NAME")
    private String name;

    @Column(name="CLIENT")
    private String client;

    @Column(name="COORDINATOR")
    private String coordinator;

    @Column(name="ALIAS")
    private String alias; // vidinis projekto pavadinimas

    @Column(name="START_DATE")
    private LocalDate startDate;

    @Column(name="END_DATE")
    private LocalDate endDate;

    @Column(name="CONTRACT_DATE")
    private LocalDate contractSigningDate;

    @Column(name = "ELIGIBLE_COSTS", precision=10, scale=2)
    private BigDecimal eligibleCosts; // TFI

    @Column(name = "FUNDING_RATE", precision=10, scale=8)
    private BigDecimal fundingRate;

    @Column(name = "GRANT_AMOUNT", precision=10, scale=2)
    private BigDecimal grantAmount;

    @Column(name = "INDIRECT_COST_RATE", precision=10, scale=8)
    private BigDecimal indirectCostRate;

    //    private Long paymentRequestPeriod; // mp periodiskumas, gal atskiram entity

}
