package com.farhad.example.scrummanagement.domain.model.release;

import java.util.List;

import com.farhad.example.scrummanagement.domain.model.base.ConcurrencySafeEntity;
import com.farhad.example.scrummanagement.domain.model.product.ProductId;

public class Release extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private List<ScheduledBacklogItem> scheduledBacklogItems;
}
