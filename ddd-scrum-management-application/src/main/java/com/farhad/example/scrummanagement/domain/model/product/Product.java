package com.farhad.example.scrummanagement.domain.model.product;

import java.time.LocalDate;

import com.farhad.example.scrummanagement.domain.model.StoryPoints;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItem;
import com.farhad.example.scrummanagement.domain.model.backlog.BacklogItemType;
import com.farhad.example.scrummanagement.domain.model.base.ConcurrencySafeEntity;
import com.farhad.example.scrummanagement.domain.model.release.Release;
import com.farhad.example.scrummanagement.domain.model.sprint.Sprint;
import com.farhad.example.scrummanagement.domain.model.tenant.TenantId;

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
