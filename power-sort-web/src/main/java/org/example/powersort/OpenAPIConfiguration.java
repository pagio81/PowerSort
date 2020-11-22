package org.example.powersort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Power Sort API")
                        .description("Simple REST API that accepts a list of integers and returns the sorted\n" +
                                "        list of integers as well as the sum of the data set")
                        .version("v0.0.1"));
    }

}
