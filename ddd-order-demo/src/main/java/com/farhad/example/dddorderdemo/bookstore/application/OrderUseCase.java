package com.farhad.example.dddorderdemo.bookstore.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.farhad.example.dddorderdemo.bookstore.domain.model.book.Book;
import com.farhad.example.dddorderdemo.bookstore.domain.model.book.BookId;
import com.farhad.example.dddorderdemo.bookstore.domain.model.book.BookRepository;
import com.farhad.example.dddorderdemo.bookstore.domain.model.order.Order;
import com.farhad.example.dddorderdemo.bookstore.domain.model.order.OrderFactory;
import com.farhad.example.dddorderdemo.bookstore.domain.model.order.OrderId;
import com.farhad.example.dddorderdemo.bookstore.domain.model.order.OrderRepository;
import com.farhad.example.dddorderdemo.bookstore.domain.model.user.User;
import com.farhad.example.dddorderdemo.bookstore.domain.model.user.UserId;
import com.farhad.example.dddorderdemo.bookstore.domain.model.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderUseCase {
	
	private final UserRepository userRepository;
	private final BookRepository bookRepository;
	private final OrderRepository orderRepository;

	public OrderId placeOrder(UserId userId, Map<BookId, Integer> books) {
		User user = userRepository
						.findById(userId)
						.orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));
		Map<Book, Integer> bookMap = new HashMap<>();
		for (Map.Entry<BookId, Integer> entry : books.entrySet()) {
			Book book = bookRepository
							.findById(entry.getKey())
							.orElseThrow(() -> new IllegalArgumentException("Invalid Book Id"));	
			bookMap.put(book, entry.getValue());				
		}
		Order order = OrderFactory.createOrder(user, bookMap);
		order = orderRepository.save(order);
		return order.getId();
	}
}
