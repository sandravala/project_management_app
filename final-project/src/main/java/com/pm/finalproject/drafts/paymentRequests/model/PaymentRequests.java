package com.pm.finalproject.drafts.paymentRequests.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name="PAYMENT_REQUESTS")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequests {

    @Id
    @Column(name="PAYMENT_REQUESTS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NUMBER")
    private String number; // MP01, MP02 IR TT

    @Column(name="DATE")
    private LocalDate date;

    @Column(name="APPROVED")
    private Boolean approved;

    @Column(name="APPROVAL_DATE")
    private LocalDate approvalDate;

}
