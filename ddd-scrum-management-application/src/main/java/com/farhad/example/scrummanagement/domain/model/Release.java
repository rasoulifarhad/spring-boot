package com.farhad.example.scrummanagement.domain.model;

import java.util.List;

public class Release extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private List<ScheduledBacklogItem> scheduledBacklogItems;
}
