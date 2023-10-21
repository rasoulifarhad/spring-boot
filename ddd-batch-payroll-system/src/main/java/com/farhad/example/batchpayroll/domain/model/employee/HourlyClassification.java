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
        System.out.println(timeCards);
        System.out.println(hourlyRate);
        return timeCards.stream()
            .filter(timecard -> isInPayPeriod(timecard, payCheck.getPayDate()))
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

    private boolean isInPayPeriod(TimeCard timecard, LocalDate payDate) {
        return 
            timecard.getDate().isAfter(payDate.minusWeeks(1)) 
                ? timecard.getDate().isBefore(payDate) || timecard.getDate().isEqual(payDate)
                : false;
    }
}
