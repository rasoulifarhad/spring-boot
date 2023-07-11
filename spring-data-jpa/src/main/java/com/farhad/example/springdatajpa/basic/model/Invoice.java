package com.farhad.example.springdatajpa.basic.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TypeDef;

import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoices")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(
    typeClass = MonetaryAmountType.class,
    defaultForType = MonetaryAmount.class
)
public class Invoice {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @NotNull(message = "Client id required")
    private String clientId;

    @Columns( columns = {
        @Column(name = "total_amount"),
        @Column(name = "total_currency")
    })
    @NotNull(message = "Total is required")
    private MonetaryAmount total;

    @NotNull(message = "discountPercent is required")
    @Builder.Default
    private BigDecimal discountPercent = BigDecimal.ZERO;

    @NotNull(message = "Invoice date is required")
    private LocalDate invoiceDate;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    @Column(name = "created", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

}
