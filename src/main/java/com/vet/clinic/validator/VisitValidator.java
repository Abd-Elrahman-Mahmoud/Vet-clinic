package com.vet.clinic.validator;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.vet.clinic.model.Visit;
import com.vet.clinic.repository.VisitRepository;

@Component
public class VisitValidator {

	@Autowired
	private VisitRepository visitRepository;

	public Visit validateExistence(UUID visitId) {

		return visitRepository.findById(visitId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Visit Id not exist"));
	}
}
