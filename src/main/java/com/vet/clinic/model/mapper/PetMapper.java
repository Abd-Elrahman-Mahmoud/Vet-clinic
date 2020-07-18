package com.vet.clinic.model.mapper;

import com.vet.clinic.model.Pet;
import com.vet.clinic.model.dto.CreatePetRequest;
import com.vet.clinic.model.dto.PetResponse;

public class PetMapper {

	public static PetResponse convertEntityToDto(Pet pet) {
		return PetResponse.builder().id(pet.getId()).name(pet.getName()).gender(pet.getGender())
				.dateOfBirth(pet.getDateOfBirth()).animalKind(pet.getAnimalKind()).photos(pet.getPhotos())
				.weight(pet.getWeight()).build();
	}

	public static Pet convertDtoToEntity(CreatePetRequest createPetRequest) {
		return Pet.builder().name(createPetRequest.getName()).gender(createPetRequest.getGender())
				.dateOfBirth(createPetRequest.getDateOfBirth()).animalKind(createPetRequest.getAnimalKind())
				.photos(createPetRequest.getPhotos()).weight(createPetRequest.getWeight()).build();

	}
}
