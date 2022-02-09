package com.juan.estevez.app;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configura el objeto para mapear los DTO (ModelMapper)
 * 
 * @author Juan Carlos Estevez Vargas
 */
@Configuration
public class ControlCitasConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		String path = "http://localhost:4200";
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/patient/**").allowedOrigins(path)
						.allowedMethods("GET", "POST", "PUT", "DELETE").maxAge(3600);
				registry.addMapping("/doctor/**").allowedOrigins(path)
						.allowedMethods("GET", "POST", "PUT", "DELETE").maxAge(3600);
				registry.addMapping("/appointment/**").allowedOrigins(path)
						.allowedMethods("GET", "POST", "PUT", "DELETE").maxAge(3600);
			}
		};
	}

}
