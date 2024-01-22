package com.example.kotilnspringboot.config.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@OpenAPIDefinition(info = Info(title = "Couple App", description = "couple app api명세", version = "v1"))
@Configuration
class SwaggerConfig {
    @Bean
    fun chatOpenApi(): GroupedOpenApi {
        val paths = arrayOf("/**")
        return GroupedOpenApi.builder()
                .group("COUPLE API v1")
                .pathsToMatch(*paths)
                .build()
    }
}
