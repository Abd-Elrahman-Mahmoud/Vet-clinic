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
public class CreateOwnerRequest {

	@NotBlank(message = "Mandatory Field")
	@Length(max = 256, message = "Invalid field length")
	@Pattern(regexp = "^[0-9_.\\s]*[a-zA-Z]+[a-zA-Z0-9_.\\s]*$", message = "Invalid Format")
	private String name;

	@NotBlank(message = "Mandatory Field")
	@Email(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Invalid Format")
	private String email;

	@Size(min = 11, max = 11, message = "Invalid Format")
	@Column(unique = true)
	private String phone;

	@NotNull(message = "Mandatory Field")
	private Gender gender;

	private String address;

	private List<UUID> pets;

}
