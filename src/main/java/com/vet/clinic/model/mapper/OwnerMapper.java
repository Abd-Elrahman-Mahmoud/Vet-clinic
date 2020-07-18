package com.vet.clinic.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.vet.clinic.model.Owner;
import com.vet.clinic.model.Pet;
import com.vet.clinic.model.dto.CreateOwnerRequest;
import com.vet.clinic.model.dto.OwnerResponse;
import com.vet.clinic.model.dto.PetResponse;
import com.vet.clinic.util.DataUtil;

public class OwnerMapper {

	public static OwnerResponse convertEntityToDto(Owner owner) {
		return OwnerResponse.builder().id(owner.getId()).name(owner.getName()).email(owner.getEmail())
				.phone(owner.getPhone()).gender(owner.getGender()).address(owner.getAddress())
				.pets(mapPetEntitysToDTOs(owner.getPets())).build();

	}

	public static Owner convertDtoToEntity(CreateOwnerRequest createOwnerRequest) {
		return Owner.builder().name(createOwnerRequest.getName()).email(createOwnerRequest.getEmail())
				.phone(createOwnerRequest.getPhone()).gender(createOwnerRequest.getGender())
				.address(createOwnerRequest.getAddress()).build();

	}

	public static List<PetResponse> mapPetEntitysToDTOs(List<Pet> pets) {
		return DataUtil.safeStream(pets).map(PetMapper::convertEntityToDto).collect(Collectors.toList());
	}
}
