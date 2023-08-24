package com.example.mercadolivro.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Profile("!prod")
@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.mercadolivro.controller"))
        .paths(PathSelectors.any())
        .build()

        .apiInfo(ApiInfoBuilder()
            .title("Mercado Livro")
            .description("API do Mercado Livro")
            .build())

}