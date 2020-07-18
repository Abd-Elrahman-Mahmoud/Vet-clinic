package com.vet.clinic.repository;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vet.clinic.model.Owner;

@Repository
public interface OwnerRepository extends PagingAndSortingRepository<Owner, UUID> {

}
