package com.vet.clinic.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.dto.CreateDoctorRequest;
import com.vet.clinic.model.dto.DoctorResponse;
import com.vet.clinic.model.mapper.DoctorMapper;
import com.vet.clinic.repository.DoctorRepository;
import com.vet.clinic.validator.DoctorValidator;

@Service
public class DoctorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorValidator doctorValidator;

	public DoctorResponse createDoctor(CreateDoctorRequest createDoctorRequest) {
		
		LOGGER.debug("create doctor input {}", createDoctorRequest);
		Doctor savedDoctor = doctorRepository.save(DoctorMapper.convertDtoToEntity(createDoctorRequest));
		return DoctorMapper.convertEntityToDto(savedDoctor);
	}

	public DoctorResponse getDoctor(UUID doctorId) {
		LOGGER.debug("doctor id {}", doctorId);
		return DoctorMapper.convertEntityToDto(doctorValidator.validateExistence(doctorId));
	}
}
