package com.farhad.example.dddorderdemo.bookstore.domain.model.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
	
}
