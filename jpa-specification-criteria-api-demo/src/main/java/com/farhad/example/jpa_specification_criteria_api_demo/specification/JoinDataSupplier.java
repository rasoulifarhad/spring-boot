package com.farhad.example.jpa_specification_criteria_api_demo.specification;

import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public interface JoinDataSupplier<T> {

    default Map<String, Join<Object, Object>> getJoinData(Root root, CriteriaQuery<?> query) {
        return new LinkedHashMap<>();
    }
}
