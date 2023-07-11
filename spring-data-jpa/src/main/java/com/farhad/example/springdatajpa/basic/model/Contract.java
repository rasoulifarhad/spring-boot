package com.farhad.example.springdatajpa.basic.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contracts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Contract {
    
    private static final String DEFAULT_CURRENCY = "USD"; 

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull(message = "Client id is required")
    private String clientId;

    @NotNull(message = "Invoice currency is required")
    @Builder.Default
    private Currency invoicCurrency = Currency.getInstance(DEFAULT_CURRENCY);

    @NotNull(message = "Discount percent is required")
    @Builder.Default
    private BigDecimal discountPercent = BigDecimal.ZERO;

    @Column(name = "created", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;
}
