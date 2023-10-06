package com.farhad.example.scrummanagement.domain.model.backlog;

import com.farhad.example.scrummanagement.domain.model.base.event.DomainEvent;
import com.farhad.example.scrummanagement.domain.model.sprint.SprintId;
import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BacklogItemCommited implements DomainEvent{

    private TenantId tenantId;
    private BacklogItemId backlogItemId;
    private SprintId sprintId;

    
}
