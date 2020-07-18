package com.vet.clinic.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vet.clinic.model.Visit;

@Repository
public interface VisitRepository extends PagingAndSortingRepository<Visit, UUID> {

}
