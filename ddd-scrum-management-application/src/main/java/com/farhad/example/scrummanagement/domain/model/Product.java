package com.farhad.example.scrummanagement.domain.model;

import lombok.Data;

@Data
public class Product  extends ConcurrencySafeEntity{
    
    private ProductId productId;

    private String description;
    private String name;
    private TenantId tenantId; 
}
