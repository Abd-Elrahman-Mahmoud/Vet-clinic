package com.vet.clinic;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.vet.clinic.model.Doctor;
import com.vet.clinic.model.dto.CreateDoctorRequest;
import com.vet.clinic.repository.DoctorRepository;
import com.vet.clinic.util.Util;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DoctorTestController {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private DoctorRepository doctorRepository;

	@Test
	@DisplayName("create doctor")
	public void createDoctor() throws Exception {

		CreateDoctorRequest createDoctorRequest = CreateDoctorRequest.builder().name("Ahmed").phone("01121813941")
				.photo("photo test").bio("Good Doctor").build();

		mockMvc.perform(
				post("/doctor").contentType(MediaType.APPLICATION_JSON).content(Util.toJson(createDoctorRequest)))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Ahmed")));

	}

	@Test
	@DisplayName("get doctor")
	public void getDoctor() throws Exception {

		Doctor doctor = Doctor.builder().name("Ahmed").phone("01110428132").photo("test photo").bio("good doctor")
				.build();
		doctorRepository.save(doctor);
		mockMvc.perform(get(String.format("/doctor/%s", doctor.getId())).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Ahmed")));

	}
}
