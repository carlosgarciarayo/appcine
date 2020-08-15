package com.cgr.appcine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationApp {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
