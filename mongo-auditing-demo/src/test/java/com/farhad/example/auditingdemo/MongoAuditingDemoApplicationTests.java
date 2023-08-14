package com.farhad.example.auditingdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongoAuditingDemoApplicationTests extends MongoDBTestContainerConfig {

	@Autowired
	CustomerWoVRepository customerWoVRepository;

	@BeforeEach
	public void setup() {
		customerWoVRepository.deleteAll();
	}

	@Test
	public void givenCustomer_whenIdIsNullAndSaveCustomer_thenCustomerCreateDateAndModifiedDateFilled() {
		CustomerWoV customer = CustomerWoV.builder()
											.name("customer_01")
											.build();
		CustomerWoV createdCustomer = customerWoVRepository.save(customer);
		System.out.println();
		System.out.println(createdCustomer);

		assertThat(createdCustomer.getCreatedDate()).isNotNull();
		assertThat(createdCustomer.getLastModifiedDate()).isNotNull();

	}

	@Test
	public void givenCustomer_whenIdIsSetAndSaveCustomer_thenCustomerCreateDateNotFilledButModifiedDateFilled() {
		CustomerWoV customer = CustomerWoV.builder()
													.id("blahblahblah")
													.name("customer_02")
													.build();
		CustomerWoV createdCustomer = customerWoVRepository.save(customer);
		System.out.println();
		System.out.println(createdCustomer);

		assertThat(createdCustomer.getCreatedDate()).isNull();
		assertThat(createdCustomer.getLastModifiedDate()).isNotNull();

	}

}
