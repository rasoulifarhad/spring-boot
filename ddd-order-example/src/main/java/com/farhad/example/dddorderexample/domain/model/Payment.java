package com.farhad.example.dddorderexample.domain.model;

import java.math.BigDecimal;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import lombok.Value;

public class Payment {


    private PaymentId paymentId;
    private String mode;
    private String transactionId;
    private BigDecimal amount;
    private OrderId orderId;

   @Value
    public static class  PaymentId implements ValueObject<PaymentId> {

        private String value;

        @Override
        public boolean sameValueAs(PaymentId other) {
            return this.equals(other);
        }

        public static PaymentId of(String value) {
            return new PaymentId(value);
        }
    }  
    
    @Value
    public static class  TransactionId implements ValueObject<TransactionId> {

        private String value;

        @Override
        public boolean sameValueAs(TransactionId other) {
            return this.equals(other);
        }

        public static TransactionId of(String value) {
            return new TransactionId(value);
        }
    }    
    
}