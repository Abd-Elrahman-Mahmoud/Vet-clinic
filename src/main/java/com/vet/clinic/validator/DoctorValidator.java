package com.vet.clinic.validator;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.vet.clinic.model.Doctor;
import com.vet.clinic.repository.DoctorRepository;

@Component
public class DoctorValidator {
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor validateExistence(UUID doctorId) {
		
		return doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor Id not exist"));
	}
}
