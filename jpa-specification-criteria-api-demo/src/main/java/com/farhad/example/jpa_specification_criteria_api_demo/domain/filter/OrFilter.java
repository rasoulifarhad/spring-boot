package com.farhad.example.jpa_specification_criteria_api_demo.domain.filter;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrFilter extends AbstractFilter {

    private final List<AbstractFilter> filters;

    @Override
    public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
            Map<String, Join<Object, Object>> attributeToJoin) {
                return criteriaBuilder.or(
                    filters.stream()
                       .map(filter -> 
                            filter.toPredicate(root, query, criteriaBuilder, attributeToJoin)
                        )
                       .collect(toList())
                       .toArray(Predicate[]::new));
    }

}
