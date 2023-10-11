package com.farhad.example.batchpayroll.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Quantity {
    
    private double amount;
    private Unit unit;

    public Quantity convertTo(ConversionRatio conversionRatio, Unit unit){
        double rate = conversionRatio.rateFor(this.unit,unit);
        return new Quantity(amount * rate, unit);
    }
}
