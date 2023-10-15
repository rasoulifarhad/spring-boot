package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class HourlyClassification implements PaymentClassification{
    
    private double hourlyRate;
    private List<TimeCard>  timeCards = new ArrayList<>();
    
    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getSalary() {
        double sumOhHours = timeCards.stream().mapToDouble(TimeCard::getHours).sum();
        return hourlyRate * sumOhHours ;
    }

    public TimeCard getTimeCard(LocalDate now) {
        return timeCards.stream()
                .filter(t -> t.getDate().equals(now))
                .findFirst()
                .orElse(null);
    }

    public void addTimeCard(TimeCard timeCard) {

        timeCards.add(timeCard);
    }
    
    
}
