package com.airfranceklm.fasttrack.assignment.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class HolidaysApiTest {
	@Autowired
	private HolidaysApi holidaysApi;


		@Test
		public void contextLoads() throws Exception {
			assertThat(holidaysApi).isNotNull();
		}


}
