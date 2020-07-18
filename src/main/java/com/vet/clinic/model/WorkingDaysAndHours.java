package com.vet.clinic.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Embeddable
@Data
public class WorkingDaysAndHours {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Day day;

	private LocalTime startTime;

	private LocalTime endTime;

}
