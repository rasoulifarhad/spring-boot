package com.farhad.example.scrummanagement.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product extends ConcurrencySafeEntity {

    private ProductId productId;

    private String description;
    private String name;
    private TenantId tenantId;

    public BacklogItem planBacklogItem( String aSummary, String aCategory,
            BacklogItemType aType, StoryPoints aStoryPoints) {
        return null;
    }

    public Release scheduleRelease(String aName, String aDescription,
                    LocalDate aBegins, LocalDate anEnds) {
        return null;
    }

    public Sprint scheduleSprint(String aName, String aGoals, 
                    LocalDate aBegins, LocalDate anEnds){
        return null;
    }
}
