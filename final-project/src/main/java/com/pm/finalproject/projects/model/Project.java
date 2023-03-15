package com.pm.finalproject.projects.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@Entity
@Table(name="PROJECT")
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name="PROJECT_ID")
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
    private String projectAlias; // vidinis projekto pavadinimas

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

    @OneToMany(
            mappedBy="project",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @OrderBy("procurementDeadline")
    private List<Investment> investments = new ArrayList<>();

}
