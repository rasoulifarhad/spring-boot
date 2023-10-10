package com.blubank.doctorappointment.domain.model.exception;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BusinessException extends RuntimeException {

	@NotNull
	@NotBlank
	private String code;

}
