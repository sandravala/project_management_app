package com.pm.finalproject.drafts.contracts.model;

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
@Table(name="CONTRACTS")
@NoArgsConstructor
@AllArgsConstructor
public class Contracts {

    @Id
    @Column(name="CONTRACTS_ID")
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



    //SUTARTYS
    //investicijos pavadinimas
    //terminas
    //pratesimo galimybe
    //suma
    //pastabos
    //MOKEJIMAI
    //investicijos pavadinimas
    //terminas
    //pratesimo galimybe
    //suma
    //pastabos
    //PRISTATYMO TERMINAI
    //investicijos pavadinimas
    //terminas
    //pratesimo galimybe
    //pastabos
    //KITI ISIPAREIGOJIMAI
    //investicijos pavadinimas
    //terminas
    //pratesimo galimybe
    //pastabos
}
