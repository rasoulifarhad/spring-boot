package com.blubank.doctorappointment.api.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.blubank.doctorappointment.api.dto.CreatePatientRequestDTO;
import com.blubank.doctorappointment.api.dto.CreatePatientResponseDTO;
import com.blubank.doctorappointment.domain.CommonMapStructConverters;
import com.blubank.doctorappointment.domain.model.Patient.Patient;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PatientDtoMapper {
	
    PatientDtoMapper MAPPER = Mappers.getMapper( PatientDtoMapper.class );	

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(source = "name", target = "name.firstname")
	@Mapping(source = "family", target = "name.lastname")
	@Mapping(source = "phoneNumber", target = "phoneNumber")
	Patient toPatient(CreatePatientRequestDTO createPatientRequestDTO) ;


	@Mapping(target = "name", source =  "name.firstname")
	@Mapping(target = "family", source = "name.lastname")
	@Mapping(source = "phoneNumber", target = "phoneNumber")
	@Mapping(target = "id", source =  "id")
	CreatePatientResponseDTO fromPatient(Patient patient) ;

}
