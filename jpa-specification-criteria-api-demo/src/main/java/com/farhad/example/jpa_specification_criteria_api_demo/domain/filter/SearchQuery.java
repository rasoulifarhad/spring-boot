package com.farhad.example.jpa_specification_criteria_api_demo.domain.filter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchQuery {

    private AbstractFilter filter;
    private int pageNumber;
    private int pageSize;
    private List<SortOrderMetadata> sortOrderMetadatas;
}
