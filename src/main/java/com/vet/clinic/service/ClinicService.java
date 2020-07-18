package com.vet.clinic.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vet.clinic.model.Clinic;
import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.dto.ClinicResponse;
import com.vet.clinic.model.dto.ClinicToDoctor;
import com.vet.clinic.model.dto.CreateClinicRequest;
import com.vet.clinic.model.dto.DoctorResponse;
import com.vet.clinic.model.mapper.ClinicMapper;
import com.vet.clinic.repository.ClinicRepository;
import com.vet.clinic.repository.specifications.ClinicSpecifications;
import com.vet.clinic.util.DataUtil;
import com.vet.clinic.validator.ClinicValidator;
import com.vet.clinic.validator.DoctorValidator;

@Service
@Transactional
public class ClinicService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicService.class);

	@Autowired
	private ClinicRepository clinicRepository;

	@Autowired
	private DoctorValidator doctorValidator;

	@Autowired
	private ClinicValidator clinicValidator;

	public ClinicResponse createClinic(CreateClinicRequest createClinicRequest) {

		LOGGER.debug("create clinic input {}", createClinicRequest);
		Clinic createdClinic = ClinicMapper.convertDtoToEntity(createClinicRequest);

		List<Doctor> clinicDoctors = DataUtil.safeStream(createClinicRequest.getDoctors())
				.map(doctorValidator::validateExistence).collect(Collectors.toList());
		createdClinic.setDoctors(clinicDoctors);
		clinicRepository.save(createdClinic);
		return ClinicMapper.convertEntityToDto(createdClinic);
	}

	public ClinicResponse getClinic(UUID clinicId) {
		LOGGER.debug("clinic id {}", clinicId);
		return ClinicMapper.convertEntityToDto(clinicValidator.validateExistence(clinicId));
	}

	public List<DoctorResponse> getClinicDoctors(UUID clinicId) {
		LOGGER.debug("clinic id {}", clinicId);
		Clinic clinic = clinicValidator.validateExistence(clinicId);
		return ClinicMapper.mapDoctorEntitysToDTOs(clinic.getDoctors());
	}

	public List<ClinicResponse> searchClinic(String address, String phone) {
		LOGGER.debug("address {} phone {}", address, phone);
		Specification<Clinic> clinicSpecification = ClinicSpecifications.builder().address(address).phone(phone)
				.build();
		return clinicRepository.findAll(clinicSpecification).stream().map(ClinicMapper::convertEntityToDto)
				.collect(Collectors.toList());
	}

	public ClinicResponse assignDoctorToClinic(ClinicToDoctor clinicToDoctor) {
		LOGGER.debug("clinic id {}, doctor id {}", clinicToDoctor.getClinicId(), clinicToDoctor.getDoctorId());
		Clinic clinic = clinicValidator.validateExistence(clinicToDoctor.getClinicId());

		Doctor doctor = doctorValidator.validateExistence(clinicToDoctor.getDoctorId());

		clinic.getDoctors().add(doctor);
		clinicRepository.save(clinic);
		return ClinicMapper.convertEntityToDto(clinic);
	}

	public ClinicResponse deAssignDoctorToClinic(ClinicToDoctor clinicToDoctor) {
		LOGGER.debug("clinic id {}, doctor id {}", clinicToDoctor.getClinicId(), clinicToDoctor.getDoctorId());

		Clinic clinic = clinicValidator.validateExistence(clinicToDoctor.getClinicId());

		Doctor doctor = doctorValidator.validateExistence(clinicToDoctor.getDoctorId());

		clinicValidator.validateDoctorExistInClinic(clinicToDoctor.getClinicId(), clinicToDoctor.getDoctorId());
		clinic.getDoctors().remove(doctor);
		clinicRepository.save(clinic);
		return ClinicMapper.convertEntityToDto(clinic);
	}
}
