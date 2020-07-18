package com.vet.clinic.validator;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.vet.clinic.model.Pet;
import com.vet.clinic.repository.PetRepository;

@Component
public class PetValidator {

	@Autowired
	private PetRepository petRepository;

	public Pet validateExistence(UUID petId) {

		return petRepository.findById(petId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet Id not exist"));
	}
}
