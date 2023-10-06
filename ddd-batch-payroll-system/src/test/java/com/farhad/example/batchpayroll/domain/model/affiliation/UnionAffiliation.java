package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.util.ArrayList;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.ServiceCharge;

public class UnionAffiliation implements Affiliation{
    
    private double dues;
    List<ServiceCharge> serviceCharges = new ArrayList<>();

}
