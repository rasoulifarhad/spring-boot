package com.farhad.example.scrummanagement.domain.model.product;

import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

public interface ProductRepository {

    Product productOfId(TenantId tenantId, ProductId productId);
    
}
