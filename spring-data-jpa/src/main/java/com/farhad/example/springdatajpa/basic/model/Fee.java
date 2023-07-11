package com.farhad.example.springdatajpa.basic.model;

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
@Table(name = "fees")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(
    typeClass = MonetaryAmountType.class,
    defaultForType = MonetaryAmount.class
)
public class Fee {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull(message = "Client id required")
    private String clientId;

    private String description;

    @Columns( columns = {
        @Column(name = "fee_amount"),
        @Column(name = "fee_currency")
    })
    @NotNull(message = "Amount is required")
    private MonetaryAmount amount;

    @Column(name = "created", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;
}
