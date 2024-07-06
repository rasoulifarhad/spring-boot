package com.farhad.example.jpa_specification_criteria_api_demo.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortOrderMetadata {

    String field;
    SortOrder order;
}
