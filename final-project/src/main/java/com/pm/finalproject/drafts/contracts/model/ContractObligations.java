package com.pm.finalproject.drafts.contracts.model;

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
@Table(name="CONTRACT_OBLIGATIONS")
@NoArgsConstructor
@AllArgsConstructor
public class ContractObligations {

    @Id
    @Column(name="CONTRACT_OBLIGATIONS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="COSTS_NAME")
    private String name;

    @Column(name="COSTS_AMOUNT")
    private BigDecimal costsAmount;

    @Column(name="CONTRACT_DEADLINE")
    private LocalDate contractDeadline;

    @Column(name="CAN_BE_EXTENDED")
    private Boolean canBeExtended;

    @Column(name="NOTES")
    private String notes;


}
