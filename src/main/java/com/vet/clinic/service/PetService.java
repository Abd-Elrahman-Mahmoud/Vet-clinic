package com.vet.clinic.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.clinic.model.Pet;
import com.vet.clinic.model.dto.CreatePetRequest;
import com.vet.clinic.model.dto.PetResponse;
import com.vet.clinic.model.mapper.PetMapper;
import com.vet.clinic.repository.PetRepository;
import com.vet.clinic.validator.PetValidator;

@Service
public class PetService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PetService.class);
	
	@Autowired
	private PetRepository petRepository;

	@Autowired
	private PetValidator petValidator;

	public PetResponse createPet(CreatePetRequest createPetRequest) {

		LOGGER.debug("create pet input {}", createPetRequest);
		Pet savedPet = petRepository.save(PetMapper.convertDtoToEntity(createPetRequest));
		return PetMapper.convertEntityToDto(savedPet);
	}

	public PetResponse getPet(UUID petId) {

		LOGGER.debug("pet id {}", petId);
		return PetMapper.convertEntityToDto(petValidator.validateExistence(petId));
	}
}
