package com.vet.clinic.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vet.clinic.model.Clinic;

@Repository
public interface ClinicRepository extends PagingAndSortingRepository<Clinic, UUID> {

	List<Clinic> findAll(Specification<Clinic> specifications);
}