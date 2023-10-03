package com.farhad.example.scrummanagement.domain.service;

import javax.transaction.Transactional;

import com.farhad.example.scrummanagement.domain.model.BacklogItem;
import com.farhad.example.scrummanagement.domain.model.BacklogItemRepository;
import com.farhad.example.scrummanagement.domain.model.BacklogItemType;
import com.farhad.example.scrummanagement.domain.model.Product;
import com.farhad.example.scrummanagement.domain.model.ProductId;
import com.farhad.example.scrummanagement.domain.model.ProductRepository;
import com.farhad.example.scrummanagement.domain.model.StoryPoints;
import com.farhad.example.scrummanagement.domain.model.TenantId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductBacklogItemService {

    private final ProductRepository productRepository;
    private final BacklogItemRepository backlogItemRepository;

    @Transactional
    public void planProductBacklogItem(String aTenantId, String aProductId,
            String aSummary, String aCategory,
            String aBacklogItemType, String aStoryPoints) {

        Product product = productRepository.productOfId(
                new TenantId(aTenantId),
                new ProductId(aProductId));

        BacklogItem plannedBacklogItem = product.planBacklogItem(
                aSummary,
                aCategory,
                BacklogItemType.valueOf(aBacklogItemType),
                StoryPoints.valueOf(aStoryPoints));

        backlogItemRepository.add(plannedBacklogItem);
    }
}
