package com.farhad.example.discount.application;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "breakPoint")
public class BreakPointWithRate {

	private final Amount breakPoint;
	private final Rate rate;
	public BreakPointWithRate(Amount breakPoint, Rate rate) {

      if (breakPoint == null) {
            throw new NullPointerException("BreakPoint cannot be null");
        }
        if (rate == null) {
            throw new NullPointerException("Rate cannot be null");
        }
		this.breakPoint = breakPoint;
		this.rate = rate;
	}

	
}
