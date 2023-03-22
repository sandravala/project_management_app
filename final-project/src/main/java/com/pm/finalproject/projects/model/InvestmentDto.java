package com.pm.finalproject.projects.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static org.aspectj.runtime.internal.Conversions.longValue;

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
    private Long projectId;

}
