package ru.api.library.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.info(libraryInfo());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/swagger-ui/");
	}

	private Info libraryInfo() {
		return new Info()
			.title("Library API")
			.description("API для управления книгами и клиентами")
			.version("local");
	}
}
