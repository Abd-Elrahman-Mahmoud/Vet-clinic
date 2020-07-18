package com.vet.clinic.model.dto;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.vet.clinic.model.WorkingDaysAndHours;

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
public class CreateClinicRequest {

	@NotBlank(message = "Mandatory Field")
	@Length(max = 256, message = "Invalid field length")
	@Pattern(regexp = "^[0-9_.\\s]*[a-zA-Z]+[a-zA-Z0-9_.\\s]*$", message = "Invalid Format")
	private String name;

	@NotBlank(message = "Mandatory Field")
	private String address;

	@Size(min = 11, max = 11, message = "Invalid Format")
	@Column(unique = true)
	private String phone;

	@NotNull(message = "Mandatory Field")
	private List<WorkingDaysAndHours> workingDaysAndHours;

	@NotBlank(message = "Mandatory Field")
	@Email
	private String email;

	private List<String> socialNetworkURLs;
	private List<UUID> doctors;

}
