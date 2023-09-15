package com.farhad.example.hexagonalbankaccount.application.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountId implements Serializable{
	private Long value;

}
