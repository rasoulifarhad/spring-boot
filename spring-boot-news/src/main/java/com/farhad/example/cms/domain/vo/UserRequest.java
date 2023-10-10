package com.farhad.example.cms.domain.vo;

import com.farhad.example.cms.domain.models.Role;

import lombok.Data;

@Data
public class UserRequest {
	
	String identity;

	String name;
  
	Role role;
}
