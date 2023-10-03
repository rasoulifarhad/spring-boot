package com.farhad.example.scrummanagement.domain.model;

import java.util.Set;

import lombok.Data;

@Data
public class Product  extends ConcurrencySafeEntity{
     
    private Set<BacklogItem> backlogItems;
    private String description;
    private String name;
    private ProductId productId;
    private Set<Release> releases;
    private Set<Sprint> sprints;
    private TenantId tenantId; 
}
