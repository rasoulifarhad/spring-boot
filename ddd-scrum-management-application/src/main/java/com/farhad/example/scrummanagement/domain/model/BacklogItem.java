package com.farhad.example.scrummanagement.domain.model;

import java.util.List;

public class BacklogItem extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private List<Task> tasks;
}
