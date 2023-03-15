package com.pm.finalproject.projects.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name="INVESTMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Investment {


    @Id
    @Column(name="INVESTMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="PROCUREMENT_TYPE")
    private String procurementType;

    @Column(name="NAME")
    private String name;

    @Column(name="PLANNED_COST_AMOUNT")
    private BigDecimal plannedCostAmount;

    @Column(name="ACTUAL_CONTRACT_COST")
    private BigDecimal actualContractCosts;

    @Column(name="FUNDING_RATE")
    private BigDecimal fundingRate;

    @Column(name="FUNDING_AMOUNT")
    private BigDecimal fundingAmount; // service reikes padaryti, kad kuriant cost entity automatiskai paskaiciuotu funding amount

    @Column(name="PROCUREMENT_DEADLINE")
    private LocalDate procurementDeadline; // iki kada turi buti pirkimas pradetas || sutartis pasirasyta

    @Column(name="PROCUREMENT_STATE")
    private String procurementState; // planuojama || vykdoma || ivykdyta (pasirasyta sutartis)|| atsisakyta

    @ManyToOne
    @JoinColumn(name="PROJECT_ID", nullable = false)
    private Project project;
}
