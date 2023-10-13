package com.blubank.doctorappointment.api.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.blubank.doctorappointment.api.dto.CreatePatientRequestDTO;
import com.blubank.doctorappointment.api.dto.CreatePatientResponseDTO;
import com.blubank.doctorappointment.domain.CommonMapStructConverters;
import com.blubank.doctorappointment.domain.model.Patient.Patient;
import com.blubank.doctorappointment.domain.model.Patient.Patient.PatientId;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientDtoMapper {
	
    PatientDtoMapper MAPPER = Mappers.getMapper( PatientDtoMapper.class );	

	@Mapping(source = "id", target = "id")
	@Mapping(target = "version", ignore = true)
	@Mapping(source = "dto.name", target = "name.firstname")
	@Mapping(source = "dto.family", target = "name.lastname")
	@Mapping(source = "dto.phoneNumber", target = "phoneNumber")
	Patient toPatient(CreatePatientRequestDTO dto, PatientId id) ;


	@Mapping(target = "name", source =  "name.firstname")
	@Mapping(target = "family", source = "name.lastname")
	@Mapping(source = "phoneNumber", target = "phoneNumber")
	@Mapping(target = "id", source =  "id")
	CreatePatientResponseDTO fromPatient(Patient patient) ;

}
