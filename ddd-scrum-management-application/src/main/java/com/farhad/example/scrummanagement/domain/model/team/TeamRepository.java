package com.farhad.example.scrummanagement.domain.model.team;

import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

public interface TeamRepository {

    Team teamOfId(TenantId tenantId, TeamId teamId);
    
}
