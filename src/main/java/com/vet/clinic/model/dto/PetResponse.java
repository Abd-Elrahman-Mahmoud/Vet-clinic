package com.vet.clinic.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.vet.clinic.model.Gender;

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
public class PetResponse {

	private UUID id;
	private String name;

	@NotBlank
	private Gender gender;

	private LocalDate dateOfBirth;

	@NotBlank
	private String animalKind;

	private List<String> photos;

	private float weight;

}
