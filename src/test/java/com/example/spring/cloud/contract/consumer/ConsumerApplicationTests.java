package com.example.spring.cloud.contract.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.example.spring.cloud.contract:producer:+:stubs:8080"},
		stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ConsumerApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldReturnMyMovie() throws IOException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/movie/1", HttpMethod.GET,
				new HttpEntity<>(null, httpHeaders),
				String.class);

		Movie movie = objectMapper.readValue(response.getBody(), Movie.class);

		assertThat(movie.getId()).isEqualTo("1");
		assertThat(movie.getName()).isEqualTo("My Movie");
		assertThat(movie.getGenre()).isEqualTo("Action");
		assertThat(movie.getYear()).isEqualTo("2019");
	}
}