package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.blubank.doctorappointment.domain.CommonMapStructConverters;
import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.patient.PatientJpaEntity;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientJpaMapper {
	
    PatientJpaMapper MAPPER = Mappers.getMapper( PatientJpaMapper.class );	

	@Mapping(source = "firstname", target = "name.firstname")
	@Mapping(source = "lastname", target = "name.lastname")
	Patient toPatient(PatientJpaEntity jpaEntity) ;


	@Mapping(target = "firstname", source =  "name.firstname")
	@Mapping(target = "lastname", source = "name.lastname")
	PatientJpaEntity fromPatient(Patient patient) ;

}
