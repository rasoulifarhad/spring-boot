package com.farhad.example.jpa_specification_criteria_api_demo.domain.filter;

import java.util.Map;
import java.util.Objects;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public abstract class AbstractFilter {

    public abstract Predicate toPredicate(
        Root<?> root, 
        CriteriaQuery<?> query, 
        CriteriaBuilder criteriaBuilder,
        Map<String, Join<Object, Object>> attributeToJoin);

    public Predicate getPredicate(Filter filter, CriteriaBuilder criteriaBuilder, Path expression ) {
        Predicate predicate = null;
        switch(filter.getOperator()) {
            case EQUAL_TO:
                predicate = criteriaBuilder.equal(expression, filter.getValue());
                break;
            case LIKE:
                predicate = criteriaBuilder.like(expression, "%" + filter.getValue() + "%");
                break;
            case IN:
                predicate = criteriaBuilder.in(expression).value(filter.getValue());
                break;
            case GT:
                predicate = criteriaBuilder.greaterThan(expression, (Comparable) filter.getValue());
                break;
            case LT:
                predicate = criteriaBuilder.lessThan(expression, (Comparable) filter.getValue());
                break;
            case GTE:
                predicate = criteriaBuilder.greaterThanOrEqualTo(expression, (Comparable) filter.getValue());
                break;
            case LTE:
                predicate = criteriaBuilder.lessThanOrEqualTo(expression, (Comparable) filter.getValue());
                break;
            case NOT_EQUAL_TO:
                predicate = criteriaBuilder.notEqual(expression, filter.getValue());
                break;
            case IS_NULL:
                predicate = criteriaBuilder.isNull(expression);
                break;
            case IS_NOT_NULL:
                predicate = criteriaBuilder.isNotNull(expression);
                break;
            default:
                throw new IllegalArgumentException(filter.getOperator() + " is not valid operator");
        }
        return predicate;
    }

    public Predicate getPredicateFromFilter(Filter filter, 
        Root<?> root, 
        CriteriaBuilder criteriaBuilder,
        Map<String, Join<Object, Object>> attributeToJoin) {
            Objects.requireNonNull(filter);
            if(attributeToJoin != null && attributeToJoin.get(filter.getEntityName()) != null) {
                return getPredicate(
                    filter, 
                    criteriaBuilder, 
                    attributeToJoin.get(
                        filter.getEntityName())
                            .get(
                                filter.getField()));
            } else {
                return getPredicate(
                    filter, 
                    criteriaBuilder, 
                    root.get(
                        filter.getField()));
            }
            
    }
}
