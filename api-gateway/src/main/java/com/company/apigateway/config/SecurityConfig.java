package com.company.apigateway.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] freeResourceUrls={

            "/swagger-ui.html",
            "/swagger-ui/**",
            "swagger-resources/**",
            "/v3/api-docs/**",
            "/api-docs/**",
            "/aggregate/**"

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        try {
            return httpSecurity.authorizeHttpRequests(
                    (authorize) -> authorize
                            .requestMatchers(freeResourceUrls)
                            .permitAll()
                            .anyRequest()
                            .authenticated()).oauth2ResourceServer(
                    (oauth2) -> oauth2.jwt(
                      Customizer.withDefaults()))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
