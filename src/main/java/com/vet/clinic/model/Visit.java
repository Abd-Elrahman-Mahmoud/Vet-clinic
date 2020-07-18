package com.vet.clinic.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visit {

	@Id
	@GeneratedValue
	private UUID id;

	@OneToOne
	private Pet pet;

	@OneToOne
	private Doctor doctor;

	@OneToOne
	private Clinic clinic;

	private LocalDate date;

}
