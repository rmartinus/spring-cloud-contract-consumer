package com.example.spring.cloud.contract.consumer;

import org.assertj.core.api.Assertions;
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

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.example.spring.cloud.contract:producer:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ContractTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldReturnMyMovie() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/movie/1", HttpMethod.GET,
                new HttpEntity<>(null, httpHeaders),
                String.class);

        assertThat(response.getBody()).isEqualTo("{\"year\":\"2019\",\"genre\":\"Action\",\"name\":\"My Movie\",\"movieId\":\"1\"}");
    }
}
