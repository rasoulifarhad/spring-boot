package com.farhad.example.scrummanagement.domain.model.backlog.task;

import java.util.List;

import com.farhad.example.scrummanagement.domain.model.backlog.EstimatiesLegEntry;

public class Task {

    private List<EstimatiesLegEntry> estimatiesLegEntries;
    private String description;
    private int hoursRemaining;
}
