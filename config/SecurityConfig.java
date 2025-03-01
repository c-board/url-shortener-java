package com.urlshortener.url_shortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Be explicit about allowed methods
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Be explicit about allowed headers
        config.setAllowedHeaders(Arrays.asList(
            "Origin", 
            "Content-Type", 
            "Accept", 
            "Authorization",
            "Access-Control-Allow-Origin",
            "Access-Control-Request-Method",
            "Access-Control-Request-Headers"
        ));
        
        // Set allowed origins
        config.setAllowedOrigins(Arrays.asList(
            "http://localhost:5173",
            "https://url-shortener-fe-production-b9a2.up.railway.app"
        ));
        
        // Allow credentials
        config.setAllowCredentials(true);
        
        // Set max age for preflight requests
        config.setMaxAge(3600L);
        
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}