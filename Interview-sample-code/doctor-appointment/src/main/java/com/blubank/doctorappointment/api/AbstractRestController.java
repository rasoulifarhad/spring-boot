package com.blubank.doctorappointment.api;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractRestController {
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleRestError(Exception ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(Collections.singletonMap("error", ex.getMessage()));

	}
}
