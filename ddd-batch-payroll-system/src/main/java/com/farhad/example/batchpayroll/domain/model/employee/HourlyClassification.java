package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

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
        return timeCards.stream()
                        .mapToDouble(this::calculatePayForTimeCard).sum();
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

    @Override
    public double calculatePay(PayCheck payCheck) {
        return timeCards.stream()
            .filter(timecard -> isInPayPeriod(timecard, payCheck))
            .mapToDouble(this::calculatePayForTimeCard)
            .sum();
    }

    @Override
    public void post(LocalDate date) {
    }
    
    private double calculatePayForTimeCard(TimeCard timeCard) {
        double overTimeHours = Math.max(0.0, timeCard.getHours() - 8);
        double normalHours = timeCard.getHours() - overTimeHours;
        return (normalHours * hourlyRate) + (hourlyRate * 1.5 * overTimeHours) ;

    }

    private boolean isInPayPeriod(TimeCard timecard, PayCheck payCheck) {
        System.out.println(timecard);
        System.out.println(payCheck);
        return isInPayPeriod(timecard.getDate(), payCheck);
    }

    private boolean isInPayPeriod(LocalDate date, PayCheck payCheck) {
        return 
            date.isAfter(payCheck.getPayPeriodStart()) 
                ? date.isBefore(payCheck.getPayPeriodEnd()) || date.isEqual(payCheck.getPayPeriodEnd())
                : false;
    }

    
}
