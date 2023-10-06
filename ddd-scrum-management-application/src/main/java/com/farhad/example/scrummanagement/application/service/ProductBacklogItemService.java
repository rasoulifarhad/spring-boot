package com.farhad.example.scrummanagement.application.service;

import javax.transaction.Transactional;

import com.farhad.example.scrummanagement.domain.model.StoryPoints;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItem;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItemId;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItemRepository;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItemType;
import com.farhad.example.scrummanagement.domain.model.backlog.task.TaskId;
import com.farhad.example.scrummanagement.domain.model.product.Product;
import com.farhad.example.scrummanagement.domain.model.product.ProductId;
import com.farhad.example.scrummanagement.domain.model.product.ProductRepository;
import com.farhad.example.scrummanagement.domain.model.team.Team;
import com.farhad.example.scrummanagement.domain.model.team.TeamMemberId;
import com.farhad.example.scrummanagement.domain.model.team.TeamRepository;
import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductBacklogItemService {
    
    private final BacklogItemRepository backlogItemRepository;
    private final TeamRepository teamRepository;
    private final ProductRepository productRepository;
    // private final TaskRepository taskRepository;

    @Transactional
    public void  assignTeamMemberToTask(
            String  aTenantId,
            String aBacklogItemId,
            String aTaskId,
            String aTeamMemberId) {
        BacklogItem backlogItem  = 
                backlogItemRepository.backlogItemOfId(
                    new TenantId(aTeamMemberId),
                    new BacklogItemId(aBacklogItemId));

        Team ofTeam = 
                teamRepository.teamOfId(
                    backlogItem.getTenantId(),
                    backlogItem.getTeamId());
    
        backlogItem.assignTeamMemberToTask(
            new TeamMemberId(aTeamMemberId),
            ofTeam,
            new TaskId(aTaskId));
    }

    @Transactional
    public void planBatchOfProductBacklogItems(
            String aTenantId,
            String productId,
            BacklogItemDescription[] aDescriptions) {
        
        Product product = 
                productRepository.productOfId(
                    new TenantId(aTenantId),
                    new ProductId(productId));
        for (BacklogItemDescription desc : aDescriptions) {
            BacklogItem plannedBacklogItem = 
                product.planBacklogItem(
                    desc.getSummary(),
                    desc.getCategory(),
                    BacklogItemType.valueOf(desc.getBacklogItemType()),
                    StoryPoints.valueOf(desc.getStoryPoints()));
            backlogItemRepository.add(plannedBacklogItem);
        }
    }
}
