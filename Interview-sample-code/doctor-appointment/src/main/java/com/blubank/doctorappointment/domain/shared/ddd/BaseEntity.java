package com.blubank.doctorappointment.domain.shared.ddd;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

@MappedSuperclass
public class BaseEntity<Id extends Serializable> extends AbstractPersistable<Id> {

	@Version
	private Long version;

	public @NotNull Optional<Long> getVersion() {
		return Optional.ofNullable(version);
	}

	protected void setVersion(@Nullable Long version) { // <4>
		this.version = version;
	}
}
