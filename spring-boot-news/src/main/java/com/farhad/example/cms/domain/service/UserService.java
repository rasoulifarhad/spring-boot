package com.farhad.example.cms.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.farhad.example.cms.domain.models.User;
import com.farhad.example.cms.domain.repository.UserRepository;
import com.farhad.example.cms.domain.vo.UserRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	

	private final UserRepository userRepository;

	public User update(String id, UserRequest userRequest) {
		final User user = userRepository.findOne(id);
		user.setIdentity(userRequest.getIdentity());
		user.setName(userRequest.getName());
		user.setRole(userRequest.getRole());
		return userRepository.save(user);
	}

	public User create(UserRequest userRequest) {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setIdentity(userRequest.getIdentity());
		user.setName(userRequest.getName());
		user.setRole(userRequest.getRole());
		return userRepository.save(user);
	}

	public void delete(String id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(String id) {
		return userRepository.findOne(id);
	}

}
