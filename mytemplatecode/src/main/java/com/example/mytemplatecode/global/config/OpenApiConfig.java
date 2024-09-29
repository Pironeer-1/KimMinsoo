package com.example.mytemplatecode.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "MyTemplateCode API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "김민수",
                        email = "kimminsoo116@gmail.com"
            )
    )
)

@Configuration
public class OpenApiConfig {
}
