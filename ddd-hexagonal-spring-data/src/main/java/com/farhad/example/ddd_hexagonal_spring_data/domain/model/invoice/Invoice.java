package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class Invoice {

    private String number;
    
    private List<LineItem> lineItems = new ArrayList<>();

    public void addItem(@NonNull LineItem item) {
        lineItems.add(item);
    }
}
