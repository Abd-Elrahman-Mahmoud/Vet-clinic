package com.vet.clinic.model.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.vet.clinic.model.Day;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingDaysAndHoursDTO {

	@Enumerated(EnumType.STRING)
	private Day day;

	private Long startTime;

	private Long endTime;
}
