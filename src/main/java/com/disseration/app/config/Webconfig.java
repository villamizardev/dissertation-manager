package com.disseration.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
	@Value("${empleos.ruta.imagenes}")
	private String ruta;
	
	@Value("${empleos.ruta.imagenes.alias}")
	private String alias;

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(alias).addResourceLocations("file:" + ruta);
	}
}
