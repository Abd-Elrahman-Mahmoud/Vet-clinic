package com.vet.clinic.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class VisitResponse {

	private UUID id;
	private PetResponse pet;
	private DoctorResponse doctor;
	private ClinicResponse clinic;
	private LocalDate date;

}
