package com.pm.finalproject.projects.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private String projectNo;
    private String name;
    private String client;
    private String coordinator;
    private String projectAlias;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate contractSigningDate;
    private BigDecimal eligibleCosts; // amount
    private BigDecimal fundingRate;
    private BigDecimal grantAmount;
    private BigDecimal indirectCostRate;
    private List<InvestmentDto> investmentDtos;

}
