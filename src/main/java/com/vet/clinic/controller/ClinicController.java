package com.vet.clinic.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vet.clinic.model.dto.ClinicResponse;
import com.vet.clinic.model.dto.ClinicToDoctor;
import com.vet.clinic.model.dto.CreateClinicRequest;
import com.vet.clinic.model.dto.DoctorResponse;
import com.vet.clinic.service.ClinicService;

@RestController
@RequestMapping("/clinic")
@Validated
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@PostMapping
	public ClinicResponse createClinic(@Valid @RequestBody CreateClinicRequest createClinicRequest) {
		return clinicService.createClinic(createClinicRequest);
	}

	@GetMapping("/{id}")
	public ClinicResponse getClinic(@PathVariable(name = "id") UUID id) {
		return clinicService.getClinic(id);
	}

	@GetMapping("/{id}/doctors")
	public List<DoctorResponse> getClinicDoctors(@PathVariable(name = "id") UUID id) {
		return clinicService.getClinicDoctors(id);
	}

	@GetMapping()
	public List<ClinicResponse> searchClinic(@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "phone", required = false) String phone) {

		return clinicService.searchClinic(address, phone);
	}

	@PutMapping("/assign/doctor")
	public ClinicResponse assignDoctorToClinic(@Valid @RequestBody ClinicToDoctor clinicToDoctor) {
		return clinicService.assignDoctorToClinic(clinicToDoctor);
	}

	@PutMapping("/de-assign/doctor")
	public ClinicResponse deAssignDoctorToClinic(@Valid @RequestBody ClinicToDoctor clinicToDoctor) {
		return clinicService.deAssignDoctorToClinic(clinicToDoctor);
	}
}
