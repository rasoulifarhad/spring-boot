package com.farhad.example.scrummanagement.application.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class BacklogItemDescription {
    private String summary;
    private String category;
    private String backlogItemType;
    private String storyPoints;
}
