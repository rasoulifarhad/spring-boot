package com.blubank.doctorappointment.infrastructure.persistence.jpa.appointment;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "appointments")
@Builder
public class AppointmentJpaEntity {
	
	@Id 
	private @Nullable String id;

	@Version
	private Long version;

	public @NotNull Optional<Long> getVersion() {
		return Optional.ofNullable(version);
	}

	protected void setVersion(@Nullable Long version) { // <4>
		this.version = version;
	}
}
