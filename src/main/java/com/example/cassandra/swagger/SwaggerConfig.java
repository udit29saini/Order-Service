package com.example.cassandra.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket config(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("OrderServiceCass")
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    public ApiInfo apiDetails(){
        return new ApiInfo("Order service Cassandra Api Documentation",
                "Apis for Order Service Cassandra management",
                "1.0",
                "Free to use",
                new springfox.documentation
                        .service
                        .Contact("Shadow Project", "", ""),
                "API License",
                "",
                Collections.emptyList());
    }

}
