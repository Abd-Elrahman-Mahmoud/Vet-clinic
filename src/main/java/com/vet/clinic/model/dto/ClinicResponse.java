package com.vet.clinic.model.dto;

import java.util.List;
import java.util.UUID;

import com.vet.clinic.model.WorkingDaysAndHours;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClinicResponse {

	private UUID id;
	private String name;
	private String address;
	private String phone;

	private List<WorkingDaysAndHours> workingDaysAndHours;

	private String email;
	private List<String> networkURLs;
	private List<DoctorResponse> doctors;

}
