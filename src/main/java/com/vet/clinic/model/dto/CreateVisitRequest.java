package com.vet.clinic.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CreateVisitRequest {

	@NotNull(message = "Mandatory Field")
	private UUID pet;
	@NotNull(message = "Mandatory Field")
	private UUID doctor;
	@NotNull(message = "Mandatory Field")
	private UUID clinic;
	@NotNull(message = "Mandatory Field")
	private LocalDate date;
}
