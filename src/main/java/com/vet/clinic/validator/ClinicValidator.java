package com.vet.clinic.validator;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.vet.clinic.model.Clinic;
import com.vet.clinic.model.Doctor;
import com.vet.clinic.repository.ClinicRepository;
import com.vet.clinic.repository.DoctorRepository;

@Component
public class ClinicValidator {

	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	public Clinic validateExistence(UUID clinicId) {

		return clinicRepository.findById(clinicId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinic Id not exist"));
	}

	public void validateDoctorExistInClinic(UUID clinicId, UUID doctorId) {

		Clinic clinic = clinicRepository.findById(clinicId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinic Id not exist"));

		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor Id not exist"));

		if (!clinic.getDoctors().contains(doctor))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not exist in the clinic");
	}
}
