package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.ArrayList;
import java.util.List;

public class HourlyEmployee extends Employee{
    
    private List<TimeCard> timeCards = new ArrayList<>();
}
