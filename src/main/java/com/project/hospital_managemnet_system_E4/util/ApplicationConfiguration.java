package com.project.hospital_managemnet_system_E4.util;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Hospital Management System")
				.description("The Hospital Management System is a comprehensive Spring Boot-based project designed to manage hospital operations digitally. "
                        + "It handles patient registrations, doctor appointments, billing, lab test management, pharmacy inventory, and administrative workflows. "
                        + "This system aims to streamline hospital processes, improve efficiency, and ensure better patient care.")
				.version("1.0").contact(new Contact().name("M.Sanjana").email("sanjana@gmail.com"))
				.license(new License().name("License").url("#")));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").packagesToScan("com.project.hospital_managemnet_system_E4").build();
	}
}
