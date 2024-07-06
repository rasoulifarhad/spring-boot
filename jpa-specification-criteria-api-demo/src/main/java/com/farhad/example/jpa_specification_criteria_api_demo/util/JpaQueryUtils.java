package com.farhad.example.jpa_specification_criteria_api_demo.util;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.farhad.example.jpa_specification_criteria_api_demo.domain.Department;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class JpaQueryUtils {

    @PersistenceContext
    private EntityManager entityManager;

    public void createTupleQuery(){
        CriteriaQuery<Tuple> tupleQuery = entityManager.getCriteriaBuilder().createTupleQuery();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Root<Employee> employeeRoot = tupleQuery.from(Employee.class);

        printFirst(
            getResult(
                getTypedQuery(
                    applySpecification(defineSpecification(), 
                                        employeeRoot, 
                                        tupleQuery, 
                                        builder))));
    }

    public Specification<Employee> defineSpecification() {
        Specification<Employee> specification = (root, query, criteriaBuilder) -> {
            Join<Object, Object> joinDepartment = root.join("department", JoinType.INNER);
            Predicate employeeSalaryPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("salary"),90 );
            Predicate departmentNamePredicate = criteriaBuilder.equal(joinDepartment.get("name"), "Engineering");
            query.multiselect(root, joinDepartment);
            return criteriaBuilder.and(employeeSalaryPredicate, departmentNamePredicate);
        };

        return specification;
    }

    public CriteriaQuery<Tuple> applySpecification(
            Specification<Employee> specification, 
            Root<Employee> employeeRoot, 
            CriteriaQuery<Tuple> query, 
            CriteriaBuilder builder) {
        Predicate predicate = specification.toPredicate(employeeRoot, query, builder);
        return query.where(predicate);
    }

    public TypedQuery<Tuple> getTypedQuery(CriteriaQuery<Tuple> tupleQuery) {
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(tupleQuery);
        return typedQuery;
    }

    public List<Tuple> getResult(TypedQuery<Tuple> typedQuery) {
        List<Tuple> result = typedQuery.getResultList();
        return result;
    }

    public void printFirst(List<Tuple> list) {
        Tuple tuple = list.get(0);
        Employee employee = tuple.get(0, Employee.class);
        Department department = tuple.get(1, Department.class);
        System.out.println(employee);
        System.out.println(department);
    }
}
