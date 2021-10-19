package com.flight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	private static final String BASIC_AUTH = "basicAuth";
	
	@Bean
	public Docket api() {
		HttpAuthenticationScheme authenticationScheme = HttpAuthenticationScheme
	            .BASIC_AUTH_BUILDER
	            .name("Basic Authentication")
	            .build();
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.flight"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointInfo())
				.securitySchemes(Collections.singletonList(authenticationScheme))
                .securityContexts(List.of(securityContext()));
		
	}
	public ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder().title("Flight Booking Project")
				.description("flight booking app")
				.contact(new Contact("Project","https://FlightBookingproject.com","spriyadharshini278@gmail.com"))
				.licenseUrl("http://www.apache.org/licenses/LICENCE-2.0.html")
				.version("0.0.1-SNAPSHOT")
				.build();
	}

	   private SecurityContext securityContext() {
	       return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference())).build();
	   }
	   private SecurityReference basicAuthReference() {
	       return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	   }

}