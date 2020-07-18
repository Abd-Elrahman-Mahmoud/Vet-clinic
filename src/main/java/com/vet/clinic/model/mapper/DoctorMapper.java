package com.vet.clinic.model.mapper;

import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.dto.CreateDoctorRequest;
import com.vet.clinic.model.dto.DoctorResponse;

public class DoctorMapper {

	public static DoctorResponse convertEntityToDto(Doctor doctor) {
		return DoctorResponse.builder().id(doctor.getId()).name(doctor.getName()).phone(doctor.getPhone())
				.photo(doctor.getPhoto()).bio(doctor.getBio()).build();

	}

	public static Doctor convertDtoToEntity(CreateDoctorRequest createDoctorRequest) {
		return Doctor.builder().name(createDoctorRequest.getName()).phone(createDoctorRequest.getPhone())
				.photo(createDoctorRequest.getPhoto()).bio(createDoctorRequest.getBio()).build();

	}
}
