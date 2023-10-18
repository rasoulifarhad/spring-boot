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
	
	protected static final String SHOPPING_LIST_URI = "/api/v1/shoppinglists";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createShoppingListTest() throws Exception {
		mockMvc.perform(
					post(SHOPPING_LIST_URI + "/"))
				.andExpect(status().isCreated());
	}

   @Test
    void addItemToTheShoppingList() throws Exception {
		UUID shippingListId = UUID.randomUUID();
        String uri = String.format("%s/%s/items", SHOPPING_LIST_URI, shippingListId);
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

		UUID shippingListId = UUID.randomUUID();
        String uri = String.format("%s/%s/items", SHOPPING_LIST_URI, shippingListId);
        mockMvc
            .perform(post(uri)
                .queryParam("productName", "milk")
                .queryParam("price", "3.8")
                .queryParam("quantity", "1")
            )
            .andExpect(status().isCreated());

		String totalPriceUri = String.format("%s/%s/totalprice", SHOPPING_LIST_URI, shippingListId);
        mockMvc.perform(get(totalPriceUri))
            .andExpect(status().isOk());
    }	
}
