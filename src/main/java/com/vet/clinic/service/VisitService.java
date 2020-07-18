package com.vet.clinic.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.clinic.model.Clinic;
import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.Pet;
import com.vet.clinic.model.Visit;
import com.vet.clinic.model.dto.CreateVisitRequest;
import com.vet.clinic.model.dto.VisitResponse;
import com.vet.clinic.model.mapper.VisitMapper;
import com.vet.clinic.repository.VisitRepository;
import com.vet.clinic.validator.ClinicValidator;
import com.vet.clinic.validator.DoctorValidator;
import com.vet.clinic.validator.PetValidator;
import com.vet.clinic.validator.VisitValidator;

@Service
public class VisitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PetService.class);
	
	@Autowired
	private VisitRepository visitRepository;

	@Autowired
	private PetValidator petValidator;

	@Autowired
	private DoctorValidator doctorValidator;

	@Autowired
	private ClinicValidator clinicValidator;

	@Autowired
	private VisitValidator visitValidator;

	public VisitResponse createVisit(CreateVisitRequest createVisitRequest) {

		LOGGER.debug("create visit input {}", createVisitRequest);
		Pet pet = petValidator.validateExistence(createVisitRequest.getPet());
		Doctor doctor = doctorValidator.validateExistence(createVisitRequest.getDoctor());
		Clinic clinic = clinicValidator.validateExistence(createVisitRequest.getClinic());

		Visit savedVisit = Visit.builder().clinic(clinic).pet(pet).doctor(doctor).date(createVisitRequest.getDate())
				.build();
		visitRepository.save(savedVisit);
		return VisitMapper.convertEntityToDto(savedVisit);
	}

	public VisitResponse getVisit(UUID visitId) {
		
		LOGGER.debug("visit id {}", visitId);
		return VisitMapper.convertEntityToDto(visitValidator.validateExistence(visitId));
	}
}
