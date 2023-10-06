package com.farhad.example.scrummanagement.domain.model.sprint;

import java.util.List;

import com.farhad.example.scrummanagement.domain.model.base.ConcurrencySafeEntity;
import com.farhad.example.scrummanagement.domain.model.product.ProductId;

public class Sprint extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private List<CommitedBacklogItem> commitedBacklogItems;
    
}
