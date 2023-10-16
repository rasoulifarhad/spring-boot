package com.farhad.example.dddmonolithic.domain.model.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ProductPrice {

	private String currency;
	private BigDecimal value;

	public static ProductPrice of(String currency, BigDecimal value) {
		return new ProductPrice(currency, value);
	}
}
