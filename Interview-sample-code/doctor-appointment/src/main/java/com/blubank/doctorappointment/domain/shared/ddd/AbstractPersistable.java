package com.blubank.doctorappointment.domain.shared.ddd;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = "id")
@SuperBuilder
public abstract class AbstractPersistable<Id extends Serializable>  implements Persistable<Id>{
	
	Id id;

}
