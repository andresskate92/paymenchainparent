package com.macl;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * * @author ${milton.cabrera} on ${DATE} - ${TIME}
 * * @project ${PROJECT_NAME}
 * * @version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder().
                group("").packagesToScan("com.macl"). build();
    }
}