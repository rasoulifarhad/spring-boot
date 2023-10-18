package com.farhad.example.shopping.infra.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.farhad.example.shopping.core.ShoppingItem;
import com.farhad.example.shopping.core.ShoppingList;
import com.farhad.example.shopping.core.ShoppingListRepository;

@ActiveProfiles("test")
@DataJpaTest
public class JpaShoppingListRepositoryTest {

	private final ShoppingItem milkItem = ShoppingItem.of("milk", 1.8d, 1);
	private final ShoppingItem breadItem = ShoppingItem.of("bread", 3d, 1);

	@Autowired
	private ShoppingListRepository shoppingListRepository; 

	@Autowired
	private PlatformTransactionManager transactionManager;

	@AfterEach
	public void tearDown() {
		shoppingListRepository.deleteAll();
	}

	@Test
	public void crudOpertionsOnShoppingListTest() {
		//given
		TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
		ShoppingList expectedShoppingList = ShoppingList.of();
		expectedShoppingList.addItem(milkItem);
		expectedShoppingList.addItem(breadItem);
		//when
		expectedShoppingList = shoppingListRepository.save(expectedShoppingList);
		//then
		assertNotNull(expectedShoppingList.getId());
		transactionManager.commit(tx);
		// and when
		TransactionStatus tx2 = transactionManager.getTransaction(new DefaultTransactionDefinition());
		ShoppingList actualShoppingList = shoppingListRepository.findByIdOrFail(expectedShoppingList.getId());
		// then
		assertEquals(expectedShoppingList, actualShoppingList);
		transactionManager.commit(tx2);
	}
}
