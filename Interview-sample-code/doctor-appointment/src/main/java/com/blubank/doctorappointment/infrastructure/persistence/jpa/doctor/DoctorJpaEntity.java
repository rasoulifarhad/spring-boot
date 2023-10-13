package com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor;

import java.util.Optional;

import javax.persistence.Column;
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
@Table(name = "doctors")
@Builder
public class DoctorJpaEntity {
	
	@Id 
	private @Nullable String id;

	@Column(name = "name_first")
	private String firstname;

	@Column(name = "name_last")
	private String lastname;

	@Version
	private Long version;

	public @NotNull Optional<Long> getVersion() {
		return Optional.ofNullable(version);
	}

	protected void setVersion(@Nullable Long version) { // <4>
		this.version = version;
	}	
}
