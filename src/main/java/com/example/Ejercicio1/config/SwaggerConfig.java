package com.example.Ejercicio1.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetalis())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiDetalis(){
        return new ApiInfo("api_rest_libros",
                "apirest_sobre_libreos",
                "1.0",
                "pascual",
                new Contact("pascual","https://www.google.com/","pascual@gmail.com"),
                "pascual",
                "https://www.google.com/",
                Collections.emptyList());
    }
}