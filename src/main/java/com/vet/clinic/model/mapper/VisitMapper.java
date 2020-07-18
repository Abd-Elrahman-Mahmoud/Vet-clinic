package com.vet.clinic.model.mapper;

import com.vet.clinic.model.Visit;
import com.vet.clinic.model.dto.VisitResponse;

public class VisitMapper {

	public static VisitResponse convertEntityToDto(Visit visit) {
		return VisitResponse.builder().id(visit.getId()).pet(PetMapper.convertEntityToDto(visit.getPet()))
				.doctor(DoctorMapper.convertEntityToDto(visit.getDoctor()))
				.clinic(ClinicMapper.convertEntityToDto(visit.getClinic())).date(visit.getDate()).build();
	}
}
