package com.vet.clinic.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.vet.clinic.model.Clinic;
import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.dto.ClinicResponse;
import com.vet.clinic.model.dto.CreateClinicRequest;
import com.vet.clinic.model.dto.DoctorResponse;
import com.vet.clinic.util.DataUtil;

public class ClinicMapper {

	public static ClinicResponse convertEntityToDto(Clinic clinic) {
		return ClinicResponse.builder().id(clinic.getId()).name(clinic.getName()).email(clinic.getEmail())
				.phone(clinic.getPhone()).address(clinic.getAddress())
				.workingDaysAndHours(clinic.getWorkingDaysAndHours()).networkURLs(clinic.getNetworkURLs())
				.doctors(mapDoctorEntitysToDTOs(clinic.getDoctors())).build();
	}

	public static Clinic convertDtoToEntity(CreateClinicRequest createClinicRequest) {
		return Clinic.builder().name(createClinicRequest.getName()).address(createClinicRequest.getAddress())
				.email(createClinicRequest.getEmail()).phone(createClinicRequest.getPhone())
				.workingDaysAndHours(createClinicRequest.getWorkingDaysAndHours())
				.networkURLs(createClinicRequest.getSocialNetworkURLs()).build();
	}

	public static List<DoctorResponse> mapDoctorEntitysToDTOs(List<Doctor> doctors) {
		return DataUtil.safeStream(doctors).map( DoctorMapper::convertEntityToDto).collect(Collectors.toList());
	}
}
