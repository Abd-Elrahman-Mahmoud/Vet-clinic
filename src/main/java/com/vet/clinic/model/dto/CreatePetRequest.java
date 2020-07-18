package com.vet.clinic.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.vet.clinic.model.Gender;

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
public class CreatePetRequest {

	@NotBlank(message = "Mandatory Field")
	@Length(max = 256, message = "Invalid field length")
	@Pattern(regexp = "^[0-9_.\\s]*[a-zA-Z]+[a-zA-Z0-9_.\\s]*$", message = "Invalid Format")
	private String name;

	@NotNull(message = "Mandatory Field")
	private Gender gender;

	private LocalDate dateOfBirth;

	@NotBlank(message = "Mandatory Field")
	private String animalKind;

	private List<String> photos = new ArrayList<>();

	private float weight;

}
