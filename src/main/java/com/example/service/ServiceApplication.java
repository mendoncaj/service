package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class ServiceApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("hi")
	String hi(@RequestParam("param") String param, HttpServletRequest request) {

		logger.info("chamada do service hi");

		String message = restTemplate().getForEntity("http://localhost:8082/welcome", String.class).getBody();

		return "Olá "+ param + ". "+ message;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
