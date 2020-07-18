package com.vet.clinic.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vet.clinic.model.dto.CreateOwnerRequest;
import com.vet.clinic.model.dto.OwnerResponse;
import com.vet.clinic.model.dto.PetResponse;
import com.vet.clinic.service.OwnerService;

@RestController
@RequestMapping("/owner")
@Validated
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@PostMapping
	public OwnerResponse createOwner(@Valid @RequestBody CreateOwnerRequest createOwnerRequest) {
		return ownerService.createOwner(createOwnerRequest);
	}

	@GetMapping("/{id}")
	public OwnerResponse getOwner(@PathVariable(name = "id") UUID id) {
		return ownerService.getOwner(id);
	}

	@GetMapping("/{id}/pets")
	public List<PetResponse> getOwnerPets(@PathVariable(name = "id") UUID id) {
		return ownerService.getOwnerPets(id);
	}
}
