package com.farhad.example.scrummanagement.domain.model;

import java.util.List;

public class Sprint extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private List<CommitedBacklogItem> commitedBacklogItems;
    
}
