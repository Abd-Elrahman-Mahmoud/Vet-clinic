package com.vet.clinic.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vet.clinic.model.Clinic;

import lombok.Builder;

@Builder
public class ClinicSpecifications implements Specification<Clinic> {

	private String phone;
	private String address;

	@Override
	public Predicate toPredicate(Root<Clinic> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate p = criteriaBuilder.conjunction();

		if (address != null) {
			p.getExpressions().add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get("address")),
					String.format("%%%s%%", address).toLowerCase())));
		}
		if (phone != null) {
			p.getExpressions().add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get("phone")),
					String.format("%%%s%%", phone).toLowerCase())));
		}

		return p;
	}

}
