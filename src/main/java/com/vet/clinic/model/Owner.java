package com.vet.clinic.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Owner {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	private String email;
	private String phone;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private List<Pet> pets;
}
