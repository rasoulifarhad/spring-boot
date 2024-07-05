package com.farhad.example.jpa_specification_criteria_api_demo.domain.filter;

import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleFilter extends AbstractFilter {

    private final Filter filter;

    @Override
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
            Map<String, Join<Object, Object>> attributeToJoin) {
                return getPredicateFromFilter(filter, root, criteriaBuilder, attributeToJoin);
    }

}
