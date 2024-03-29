package com.pm.finalproject.projects.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicInsert
@DynamicUpdate
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
            fetch = FetchType.LAZY,
            mappedBy="project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("procurementDeadline")
    @JsonManagedReference
    private List<Investment> investments;

    public void addInvestment(Investment investment) {
        if(investments == null)
            investments = new ArrayList<>();
        investments.add(investment);
    }

    public void addInvestments(List<Investment> iList) {
        if(investments == null)
            investments = new ArrayList<>();
        investments.addAll(iList);
    }


}
