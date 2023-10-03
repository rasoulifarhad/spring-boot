package com.farhad.example.dddbank.infrastructure.persistence.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResource {
    
	private Long id;
	private String username;
	private String birthDate;    
}
