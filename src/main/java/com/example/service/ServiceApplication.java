package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@EnableZipkinStreamServer
public class ServiceApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();
	}

	@GetMapping("hi")
	String hi(@RequestParam("param") String param) {

		logger.info("chamada do service hi");

		return "Hello World "+ param;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
