package com.farhad.example.shopping.infra.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.shopping.core.ShoppingList;
import com.farhad.example.shopping.core.ShoppingListRepository;

public interface JpaShoppingListRepository extends JpaRepository<ShoppingList, UUID> , ShoppingListRepository{
	
}
