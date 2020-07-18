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

import com.vet.clinic.model.dto.CreateDoctorRequest;
import com.vet.clinic.model.dto.DoctorResponse;
import com.vet.clinic.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping
	public DoctorResponse createDoctor(@Valid @RequestBody CreateDoctorRequest createDoctorRequest) {
		return doctorService.createDoctor(createDoctorRequest);
	}

	@GetMapping("/{id}")
	public DoctorResponse getDoctor(@PathVariable(name = "id") UUID id) {
		return doctorService.getDoctor(id);
	}
}
