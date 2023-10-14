package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.ServiceCharge;
import com.farhad.example.batchpayroll.domain.model.employee.Fee;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class UnionAffiliation implements Affiliation{
    
    private final double dues;
    private List<ServiceCharge> serviceCharges = new ArrayList<>();
    
    @Override
    public Fee getFee(Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'getFee'");
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.add(serviceCharge);
    }

    public ServiceCharge getServiceCharge(LocalDate now) {
        return serviceCharges.stream()
                    .filter(s -> s.getDate().equals(now))
                    .findFirst()
                    .orElse(null);
    }

}
