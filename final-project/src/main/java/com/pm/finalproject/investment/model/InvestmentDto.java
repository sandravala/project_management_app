package com.pm.finalproject.investment.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentDto {

    private Long id;
    private String procurementType;
    private String name;
    private BigDecimal plannedCostAmount;
    private BigDecimal actualContractCosts;
    private BigDecimal fundingRate;
    private BigDecimal fundingAmount;
    private LocalDate procurementDeadline;
    private String procurementState;

}