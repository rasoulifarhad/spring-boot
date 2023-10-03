package com.farhad.example.scrummanagement.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product extends ConcurrencySafeEntity {

    private ProductId productId;

    private String description;
    private String name;
    private TenantId tenantId;

    public void planBacklogItem( String aSummary, String aCategory,
            BacklogItemType aType, StoryPoints aStoryPoints) {
    }

    public void scheduleRelease(String aName, String aDescription,
                    LocalDate aBegins, LocalDate anEnds) {

    }

    public void scheduleSprint(String aName, String aGoals, 
                    LocalDate aBegins, LocalDate anEnds){

    }
}
