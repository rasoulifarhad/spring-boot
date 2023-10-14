package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class PaymentResponse {
	private String cardHolderName;
	private String cardNumber;
	private Integer expiryMonth;
	private Integer expiryYear;	

    public static PaymentResponse fromDomain(Payment payment) {
        CreditCard creditCard = payment.getCreditCard();
        return new PaymentResponse(
                creditCard.getCardHolderName(),
                creditCard.getCardNumber(),
                creditCard.getExpiryMonth().getValue(),
                creditCard.getExpiryYear().getValue()
        );
    }	
}
