package com.blubank.doctorappointment.infrastructure.persistence.jpa.patient;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.blubank.doctorappointment.domain.shared.PhoneNumber;
import com.blubank.doctorappointment.domain.shared.converter.PhoneNumberConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PatientJpaEntity {
	
	@Id 
	private @Nullable String id;

	@Column(name = "name_first")
	private String firstname;

	@Column(name = "name_last")
	private String lastname;

	@Convert(converter = PhoneNumberConverter.class)  //
	private PhoneNumber phoneNumber;

	@Version
	private Long version;

	public @NotNull Optional<Long> getVersion() {
		return Optional.ofNullable(version);
	}

	protected void setVersion(@Nullable Long version) { // <4>
		this.version = version;
	}
	
}
