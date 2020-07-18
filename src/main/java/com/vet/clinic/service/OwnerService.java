package com.vet.clinic.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.clinic.model.Owner;
import com.vet.clinic.model.Pet;
import com.vet.clinic.model.dto.CreateOwnerRequest;
import com.vet.clinic.model.dto.OwnerResponse;
import com.vet.clinic.model.dto.PetResponse;
import com.vet.clinic.model.mapper.OwnerMapper;
import com.vet.clinic.repository.OwnerRepository;
import com.vet.clinic.util.DataUtil;
import com.vet.clinic.validator.OwnerValidator;
import com.vet.clinic.validator.PetValidator;

@Service
public class OwnerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerService.class);
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private OwnerValidator ownerValidator;

	@Autowired
	private PetValidator petValidator;

	public OwnerResponse createOwner(CreateOwnerRequest createOwnerRequest) {

		LOGGER.debug("create owner input {}", createOwnerRequest);
		Owner savedOwner = OwnerMapper.convertDtoToEntity(createOwnerRequest);

		List<Pet> ownerPets = DataUtil.safeStream(createOwnerRequest.getPets()).map(petValidator::validateExistence)
				.collect(Collectors.toList());
		savedOwner.setPets(ownerPets);
		ownerRepository.save(savedOwner);
		return OwnerMapper.convertEntityToDto(savedOwner);
	}

	public OwnerResponse getOwner(UUID ownerId) {
		
		LOGGER.debug("owner id {}", ownerId);
		return OwnerMapper.convertEntityToDto(ownerValidator.validateExistence(ownerId));
	}

	public List<PetResponse> getOwnerPets(UUID ownerId) {
		
		LOGGER.debug("owner id {}", ownerId);
		Owner owner = ownerValidator.validateExistence(ownerId);
		return OwnerMapper.mapPetEntitysToDTOs(owner.getPets());
	}
}
