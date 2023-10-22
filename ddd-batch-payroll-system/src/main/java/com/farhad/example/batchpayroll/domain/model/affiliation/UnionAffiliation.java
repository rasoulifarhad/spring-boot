package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;
import com.farhad.example.batchpayroll.domain.model.ServiceCharge;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UnionAffiliation implements Affiliation{
    
    private final int memberId;
    private final double dues;
    private List<ServiceCharge> serviceCharges = new ArrayList<>();
    

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.add(serviceCharge);
    }

    public ServiceCharge getServiceCharge(LocalDate now) {
        return serviceCharges.stream()
                    .filter(s -> s.getDate().equals(now))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void post(LocalDate date) {
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }

    @Override
    public double calculateDeductions(PayCheck payCheck) {
        double totalDues = 0;
        int fridays = numberOfFridaysInPayPeriod(payCheck.getPayPeriodStart(), payCheck.getPayPeriodEnd());
        System.out.println( fridays);
        double d = serviceCharges.stream()
            .filter(s -> isInPayPeriod(s, payCheck))
            .mapToDouble(ServiceCharge::getCharge)
            .sum();

        totalDues = fridays * (d + dues);
        return totalDues;

    }

    private int numberOfFridaysInPayPeriod(LocalDate start, LocalDate end) {
        LocalDate date = start;
        int numberofFriday = 0;
        date = date.plusDays(1);
        while (date.compareTo(end) <= 0 ) {
            if(date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                numberofFriday++;
            }
            date = date.plusDays(1);
        }
        return numberofFriday;
    }
    
    private boolean isInPayPeriod(ServiceCharge serviceCharge, PayCheck payCheck) {
        System.out.println(serviceCharge);
        System.out.println(payCheck);
        return isInPayPeriod(serviceCharge.getDate(), payCheck);
    }

    private boolean isInPayPeriod(LocalDate date, PayCheck payCheck) {
        return 
            date.isAfter(payCheck.getPayPeriodStart()) 
                ? date.isBefore(payCheck.getPayPeriodEnd()) || date.isEqual(payCheck.getPayPeriodEnd())
                : false;
    }

}
