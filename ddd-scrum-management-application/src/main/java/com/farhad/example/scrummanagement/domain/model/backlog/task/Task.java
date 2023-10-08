package com.farhad.example.scrummanagement.domain.model.backlog.task;

import java.util.List;

import com.farhad.example.scrummanagement.domain.model.backlog.EstimationLegEntry;

public class Task {

    private List<EstimationLegEntry> estimatiesLegEntries;
    private String description;
    private int hoursRemaining;
    private String name;
    private String volunteer;
}
