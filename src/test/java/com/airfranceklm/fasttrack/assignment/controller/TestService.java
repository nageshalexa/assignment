package com.airfranceklm.fasttrack.assignment.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.airfranceklm.fasttrack.assignment.resources.Schedules;

import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestService {
	
	List<Schedules> test;
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@SuppressWarnings("unchecked")
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		((List<Schedules>) assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				Schedules.class))).contains(test);
	}
	
}
