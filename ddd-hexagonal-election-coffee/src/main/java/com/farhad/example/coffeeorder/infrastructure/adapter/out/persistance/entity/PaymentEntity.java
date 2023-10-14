package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentEntity {
	
	@Id
	@GeneratedValue
	private UUID id;

	@NotNull
	private UUID orderId;

	@NotNull
	private String cardHolderName;

	@NotNull
	private String cardNumber;

	@NotNull
	private Month expiryMonth;

	@NotNull
	private Year expiryYear;

	@NotNull
	private LocalDate paid;

	public Payment toDomain() {
		return new Payment(
			orderId, 
			new CreditCard(
				cardHolderName, cardNumber, expiryMonth, expiryYear), 
			paid);
	}

	public static PaymentEntity fromDomain(Payment payment) {
		PaymentEntity e = new PaymentEntity();
        e.setOrderId(payment.getOrderId());
        e.setCardHolderName(payment.getCreditCard().getCardHolderName());
        e.setCardNumber(payment.getCreditCard().getCardNumber());
        e.setExpiryMonth(payment.getCreditCard().getExpiryMonth());
        e.setExpiryYear(payment.getCreditCard().getExpiryYear());
        e.setPaid(payment.getPaid());
        return e;	
	}

}
