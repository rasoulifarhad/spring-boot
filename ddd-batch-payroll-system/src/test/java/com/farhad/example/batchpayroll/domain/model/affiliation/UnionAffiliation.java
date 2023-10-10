package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.ServiceCharge;
import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public class UnionAffiliation implements Affiliation{
    
    private double dues;
    List<ServiceCharge> serviceCharges = new ArrayList<>();
    
    @Override
    public Fee getFee(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFee'");
    }

}
