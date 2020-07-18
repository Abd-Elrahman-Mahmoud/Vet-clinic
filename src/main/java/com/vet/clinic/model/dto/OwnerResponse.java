package com.vet.clinic.model.dto;

import java.util.List;
import java.util.UUID;

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
public class OwnerResponse {

	private UUID id;

	private String name;
	private String email;
	private String phone;
	private Gender gender;
	private String address;
	private List<PetResponse> pets;

}
