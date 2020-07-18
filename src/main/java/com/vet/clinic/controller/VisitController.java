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

import com.vet.clinic.model.dto.CreateVisitRequest;
import com.vet.clinic.model.dto.VisitResponse;
import com.vet.clinic.service.VisitService;

@RestController
@RequestMapping("/visit")
@Validated
public class VisitController {

	@Autowired
	private VisitService visitService;

	@PostMapping
	public VisitResponse createVisit(@Valid @RequestBody CreateVisitRequest createVisitRequest) {
		return visitService.createVisit(createVisitRequest);
	}

	@GetMapping("/{id}")
	public VisitResponse getVisit(@PathVariable(name = "id") UUID id) {
		return visitService.getVisit(id);
	}
}
