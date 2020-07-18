package com.vet.clinic.validator;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.vet.clinic.model.Owner;
import com.vet.clinic.repository.OwnerRepository;

@Component
public class OwnerValidator {

	@Autowired
	private OwnerRepository ownerRepository;

	public Owner validateExistence(UUID ownerId) {

		return ownerRepository.findById(ownerId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner Id not exist"));
	}
}
