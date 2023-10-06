package com.farhad.example.scrummanagement.domain.model.backlog;

import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

public interface BacklogItemRepository {

    void add(BacklogItem plannedBacklogItem);

    BacklogItem backlogItemOfId(TenantId tenantId, BacklogItemId backlogItemId);
    
}
