package com.farhad.example.shopping.infra.api.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ShoppingListController.class)
public class ShoppingListControllerTest {
	
	protected static final String BASE_URI = "/api/v1/shoppinglists";

	private static final UUID MOCK_SHOPPING_LIST_ID = UUID.randomUUID();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createShoppingListTest() throws Exception {
		mockMvc.perform(
					post(BASE_URI + "/"))
				.andExpect(status().isCreated());
	}

   @Test
    void addItemToTheShoppingList() throws Exception {
        String uri = String.format("%s/%s/items", BASE_URI, MOCK_SHOPPING_LIST_ID);
        mockMvc
            .perform(post(uri)
                .queryParam("productName", "milk")
                .queryParam("price", "3.8")
                .queryParam("quantity", "1")
            )
            .andExpect(status().isCreated());
    }

    @Test
    void getTotalPrice() throws Exception {
        String uri = String.format("%s/%s/totalprice", BASE_URI, MOCK_SHOPPING_LIST_ID);
        mockMvc.perform(get(uri))
            .andExpect(status().isOk());
    }	
}
