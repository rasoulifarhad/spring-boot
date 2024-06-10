package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Payment {

    private PaymentId paymentId;
    private String mode;
    private String transactionId;
    private BigDecimal amount;
    private OrderId orderId;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PaymentId implements Serializable {

        @Getter
        private String value;

        public static PaymentId of(String value) {
            return new PaymentId(value);
        }
    }

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TransactionId implements Serializable {

        @Getter
        private String value;

        public static TransactionId of(String value) {
            return new TransactionId(value);
        }
    }

}