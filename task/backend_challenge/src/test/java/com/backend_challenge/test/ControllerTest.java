package com.backend_challenge.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend_challenge.starter.Main;
import backend_challenge.starter.controller.Employee;
import backend_challenge.starter.services.EmpService;
import backend_challenge.starter.services.States;

import static org.hamcrest.Matchers.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTest {

	
	@Autowired
	private MockMvc moc;
	
	@MockBean
	private EmpService service;
	

	
	
	@Test
	public void whenAddEmp_ThenCreateEmployee() throws Exception{
		
		Employee employee1 = new Employee(1,"Mohamed",28,States.A);
		BDDMockito.given(service.addEmployee(Mockito.any(Employee.class))).willReturn(employee1);
		
		// to convert object to json 
		ObjectMapper mapper = new ObjectMapper();
		moc.perform(post("/api/add/").contentType(MediaType.APPLICATION_JSON).
				content(mapper.writeValueAsString(employee1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.name", equalTo("Mohamed")));

		
	}
	

	
}
