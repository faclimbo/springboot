package com.sofia.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.paths(PathSelectors.ant("/cloudvendor"))
						.apis(RequestHandlerSelectors.basePackage("com.sofia.restapi"))
						.build()
						.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData() {
		return new ApiInfo("Cloud Vendor API Application",
				"Cloud Vendor Documentation",
				"1.0",
				"Cloud Vendor Service terms",
				new Contact("Francis","http://google.com","faclimbo@gmail.com"),
				"Limbo License",
				"http://google.com",
				Collections.emptyList()
				);

	}

}
