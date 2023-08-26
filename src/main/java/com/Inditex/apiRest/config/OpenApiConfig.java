package com.Inditex.apiRest.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Jose David",
                        email = "josedavidrs96@gmail.com"
                ),
                description = "OpenApi documentation for Spring Inditex ApiRest",
                title = "OpenApi specification for InditexApiRest",
                version = "1.0")
)
public class OpenApiConfig {
}
