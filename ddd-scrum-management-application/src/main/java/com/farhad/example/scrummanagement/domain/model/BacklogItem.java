package com.farhad.example.scrummanagement.domain.model;

import java.util.List;

public class BacklogItem extends ConcurrencySafeEntity{
    
    private ProductId productId;
    private ReleaseId releaseId;
    private SprintId sprintId;
    private List<Task> tasks;

    private String status;
    private String story;
    private StoryPoints storyPoints;
}
