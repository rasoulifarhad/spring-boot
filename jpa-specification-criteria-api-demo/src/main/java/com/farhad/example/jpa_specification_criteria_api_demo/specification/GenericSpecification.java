package com.farhad.example.jpa_specification_criteria_api_demo.specification;

import org.springframework.data.jpa.domain.Specification;

import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.AbstractFilter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GenericSpecification<T> implements Specification<T>{

    private AbstractFilter filter;
    private JoinDataSupplier<T> joinDataSupplier;

    @Override
    public Predicate toPredicate(
        Root<T> root, 
        CriteriaQuery<?> query, 
        CriteriaBuilder criteriaBuilder) {
            if(joinDataSupplier != null && filter != null) {
                return filter.toPredicate(root, query, criteriaBuilder, joinDataSupplier.getJoinData(root, query));
            }
            return criteriaBuilder.conjunction();
    }


}
