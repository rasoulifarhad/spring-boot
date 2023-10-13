package com.blubank.doctorappointment.infrastructure.persistence.jpa.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.blubank.doctorappointment.domain.CommonMapStructConverters;
import com.blubank.doctorappointment.domain.model.Doctor.Doctor;
import com.blubank.doctorappointment.infrastructure.persistence.jpa.doctor.DoctorJpaEntity;

@Mapper(componentModel = "spring", uses = CommonMapStructConverters.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorJpaMapper {
	
    DoctorJpaMapper MAPPER = Mappers.getMapper( DoctorJpaMapper.class );	


	@Mapping(source = "firstname", target = "name.firstname")
	@Mapping(source = "lastname", target = "name.lastname")
	Doctor toDoctor(DoctorJpaEntity jpaEntity) ;

	@Mapping(target = "firstname", source =  "name.firstname")
	@Mapping(target = "lastname", source = "name.lastname")
	DoctorJpaEntity fromDoctor(Doctor doctor) ;

}
