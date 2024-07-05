package com.farhad.example.jpa_specification_criteria_api_demo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.farhad.example.jpa_specification_criteria_api_demo.domain.Employee;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.AbstractFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.AndFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.Filter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.FilterOperator;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.OrFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.SimpleFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.specification.GenericSpecification;
import com.farhad.example.jpa_specification_criteria_api_demo.specification.JoinDataSupplier;

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

@SpringBootTest
class JpaSpecificationCriteriaApiDemoApplicationTests {

    @PersistenceContext
    private EntityManager entityManager;


	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		SimpleFilter salaryFilter = 
			new SimpleFilter(
				new Filter(
					"salary", 
					FilterOperator.GT, 
					90, 
					"Employee"));
		SimpleFilter departmentNameFilter = 
			new SimpleFilter(
				new Filter(
					"costCenter", 
					FilterOperator.EQUAL_TO, 
					"CostCenter-1", 
					"Department"));
		AndFilter firstAndFilter = new AndFilter(Arrays.asList(salaryFilter, departmentNameFilter));

		SimpleFilter salaryFilter2 = 
			new SimpleFilter(
				new Filter(
					"salary", 
					FilterOperator.GTE, 
					80, 
					"Employee"));
		SimpleFilter departmentNameFilter2 = 
			new SimpleFilter(
				new Filter(
					"costCenter", 
					FilterOperator.EQUAL_TO, 
					"CostCenter-2", 
					"Department"));
		AndFilter secondAndFilter = new AndFilter(Arrays.asList(salaryFilter2, departmentNameFilter2));
		OrFilter orFilter =  new OrFilter(Arrays.asList(firstAndFilter, secondAndFilter));
		Specification<Employee> specification = getEmployeeDepartmentJoinSpecification(orFilter);
        

		CriteriaQuery<Tuple> tupleQuery = entityManager.getCriteriaBuilder().createTupleQuery();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Root<Employee> employeeRoot = tupleQuery.from(Employee.class);

		Predicate predicate = specification.toPredicate(employeeRoot, tupleQuery, builder);
        tupleQuery.where(predicate);
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(tupleQuery);
		List<Tuple> result = typedQuery.getResultList();
		Tuple tuple = result.get(0);
		System.out.println(tuple);
	}

	public Specification<Employee> getEmployeeDepartmentJoinSpecification(AbstractFilter filter) {
		return 
			new GenericSpecification<Employee>(
				filter, new JoinDataSupplier<Employee>() {
					public Map<String, Join<Object, Object>> getJoinData(Root<Employee> root, CriteriaQuery<?> query) {
						Map<String, Join<Object, Object>> attributeToJoinMap = new LinkedHashMap<>();
						Join<Object, Object> joinDepartment = root.join("department", JoinType.INNER);
						attributeToJoinMap.put("Department", joinDepartment);
						query.multiselect(root.get("id"), root.get("firstName"), joinDepartment.get("name"));
						return attributeToJoinMap;
					}
				});
	}

}
