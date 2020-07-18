package com.vet.clinic.controller;

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

import com.vet.clinic.model.dto.CreatePetRequest;
import com.vet.clinic.model.dto.PetResponse;
import com.vet.clinic.service.PetService;

@RestController
@RequestMapping("/pet")
@Validated
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping
	public PetResponse createPet(@Valid @RequestBody CreatePetRequest createPetRequest) {
		return petService.createPet(createPetRequest);
	}

	@GetMapping("/{id}")
	public PetResponse getPet(@PathVariable(name = "id") UUID id) {
		return petService.getPet(id);
	}
}
