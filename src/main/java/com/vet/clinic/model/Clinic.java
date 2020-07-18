package com.vet.clinic.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
@Entity
public class Clinic {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	private String address;
	private String phone;

	@ElementCollection
	@Embedded
	private List<WorkingDaysAndHours> workingDaysAndHours;

	private String email;

	@ElementCollection
	private List<String> networkURLs;

	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinic_id")
	private List<Doctor> doctors;
}
