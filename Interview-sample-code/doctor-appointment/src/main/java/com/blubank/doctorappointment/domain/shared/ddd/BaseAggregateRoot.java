package com.blubank.doctorappointment.domain.shared.ddd;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseAggregateRoot<Id extends Serializable> extends BaseEntity<Id> {
	
}
