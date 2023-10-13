package com.blubank.doctorappointment.domain.shared.ddd;

import java.io.Serializable;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BaseAggregateRoot<Id extends Serializable> extends BaseEntity<Id> {
	
}
