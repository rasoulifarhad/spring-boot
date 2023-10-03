package com.farhad.example.scrummanagement.domain.model;

public interface ProductRepository {

    Product productOfId(TenantId tenantId, ProductId productId);
    
}
