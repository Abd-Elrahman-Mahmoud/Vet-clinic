package com.vet.clinic.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

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
public class CreateDoctorRequest {

	@NotBlank(message = "Mandatory Field")
	@Length(max = 256, message = "Invalid field length")
	@Pattern(regexp = "^[0-9_.\\s]*[a-zA-Z]+[a-zA-Z0-9_.\\s]*$", message = "Invalid Format")
	private String name;

	@Size(min = 11, max = 11, message = "Invalid Format")
	@Column(unique = true)
	private String phone;

	private String photo;

	private String bio;
}
