package com.farhad.example.jpa_specification_criteria_api_demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.support.PageableExecutionUtils;

import com.farhad.example.jpa_specification_criteria_api_demo.domain.Employee;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.AbstractFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.AndFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.Filter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.FilterOperator;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.OrFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.SearchQuery;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.SimpleFilter;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.SortOrder;
import com.farhad.example.jpa_specification_criteria_api_demo.domain.filter.SortOrderMetadata;
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
	private Class<Employee> entityClass;


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

		SearchQuery searchQuery = 
			new SearchQuery(
				orFilter, 
				0, 
				10, 
				Arrays.asList(new SortOrderMetadata(
								"salary", SortOrder.DESC)));

		Specification<Employee> specification = getEmployeeDepartmentJoinSpecification(searchQuery.getFilter());
		
		Page<Tuple> tuplePage = getPagedData(specification, Employee.class, searchQuery);
		// Page<Tuple> tuplePage = getPagedData(specification, Employee.class);

		List<Tuple> tupleList = tuplePage.getContent();
		// List<Tuple> result = typedQuery.getResultList();
		System.out.println(tupleList);
	}

	private PageRequest getPageRequest(SearchQuery searchQuery) {
		return PageRequest.of(searchQuery.getPageNumber(), searchQuery.getPageSize());
	}
	// private Page<Tuple> getPagedData(Specification<Employee> specification, Class<Employee> domainClass) {
	// 	TypedQuery<Tuple> typedQuery = getTupleQuery(specification, domainClass);
	// 	Page<Tuple> page = new PageImpl<>(typedQuery.getResultList());
	// 	return page;
	// }

	private Page<Tuple> getPagedData(Specification<Employee> specification, Class<Employee> domainClass, SearchQuery searchQuery) {
		PageRequest pageRequest = getPageRequest(searchQuery);
		TypedQuery<Tuple> typedQuery = getTupleQuery(specification, domainClass);
		Page<Tuple> page;
		if(pageRequest.isUnpaged()) {
			page = new PageImpl<>(typedQuery.getResultList());	
		} else {
			page = getPage(typedQuery, domainClass, pageRequest, specification);
		}
		return page;
	}

	private Page<Tuple> getPage(TypedQuery<Tuple> typedQuery, Class<Employee> domainClass, Pageable pageable,
			Specification<Employee> specification) {
				if(pageable.isPaged()) {
					typedQuery.setFirstResult((int)pageable.getOffset());
					typedQuery.setMaxResults(pageable.getPageSize());
				}
				return PageableExecutionUtils.getPage(
					typedQuery.getResultList(), 
					pageable, 
					() -> executeCountQuery(getCountQuery(specification, domainClass)));
	}


	private long executeCountQuery(TypedQuery<Long> countQuery) {
		List<Long> totals = countQuery.getResultList();
		long total = 0;
		for (Long l : totals) {
			total += (l == null) ? 0 : l;
		}
		return total;
	}

	private TypedQuery<Long> getCountQuery(Specification<Employee> specification, Class<Employee> domainClass) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<Employee> root = query.from(domainClass);
		Predicate predicate = specification.toPredicate(root, query, builder);
		if(predicate != null) {
			query.where(predicate);
		}
		query.select(builder.count(root));
		query.orderBy(Collections.emptyList());
		return entityManager.createQuery(query);
	}

	private TypedQuery<Tuple> getTupleQuery(Specification<Employee> specification, Class<Employee> domainClass) {
		CriteriaQuery<Tuple> tupleQuery = entityManager.getCriteriaBuilder().createTupleQuery();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Root<Employee> employeeRoot = applaySpecificariobToCriteria(specification, Employee.class, tupleQuery);
		return entityManager.createQuery(tupleQuery);
	}

	private Root<Employee> applaySpecificariobToCriteria(Specification<Employee> specification, Class<Employee> domainClass, CriteriaQuery<Tuple> query ) {
		Root<Employee> employeeRoot = query.from(domainClass);

		if (specification == null) {
			return employeeRoot;
		}

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Predicate predicate = specification.toPredicate(employeeRoot, query, builder);
		if(predicate != null) {
			query.where(predicate);
		}
		return employeeRoot;
	}

	public Specification<Employee> getEmployeeDepartmentJoinSpecification(AbstractFilter filter) {
		return 
			new GenericSpecification<Employee>(
				filter, new JoinDataSupplier<Employee>() {
					public Map<String, Join<Object, Object>> getJoinData(Root<Employee> root, CriteriaQuery<?> query) {
						Map<String, Join<Object, Object>> attributeToJoinMap = new LinkedHashMap<>();
						Join<Object, Object> joinDepartment = root.join("department", JoinType.INNER);
						attributeToJoinMap.put("Department", joinDepartment);
						query.multiselect(root, joinDepartment);
						// query.multiselect(root.get("id"), root.get("firstName"), joinDepartment.get("name"));
						return attributeToJoinMap;
					}
				});
	}

}
