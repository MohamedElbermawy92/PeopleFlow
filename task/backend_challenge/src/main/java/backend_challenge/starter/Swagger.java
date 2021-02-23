package backend_challenge.starter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {
	@Bean
	public Docket apiDocket() {

		Contact contact = new Contact("PeopleFlow", "https://www.peopleflow.com/", "engineering.recruitment@pplflw.com");

		List<VendorExtension> vendorExtensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("state machine Documentation", "This pages documents people flow task endpoints", "1.0",
				"https://www.peopleflow.com/", contact, "", "", vendorExtensions);

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("backend_challenge.starter.controller"))
				.paths(PathSelectors.any())
				.build();

		return docket;

	}
}
