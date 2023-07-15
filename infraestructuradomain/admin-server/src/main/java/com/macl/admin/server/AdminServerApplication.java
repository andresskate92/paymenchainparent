package com.macl.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * * @author ${milton.cabrera} on ${DATE} - ${TIME}
 * * @project ${PROJECT_NAME}
 * * @version 1.0
 **/
@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }

    @Configuration
    static class SecurityPermiteAllConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable().build();
//            httpSecurity.authorizeHttpRequests((var) -> var.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        }
    }
}