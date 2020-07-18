package com.vet.clinic.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

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
public class Doctor {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	private String phone;

	@Lob
	private String photo;

	@Lob
	private String bio;

}
