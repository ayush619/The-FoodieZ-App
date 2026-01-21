package com.ayush.springmvcboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (usually needed for non-browser clients, but often disabled for simple REST APIs)
                .csrf(csrf -> csrf.disable())
                // 2. Enable CORS explicitly
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 3. Define authorization rules (adjust as needed)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/api/**","/v2/**").permitAll() // Allow access to these paths
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // ALLOW YOUR FRONTEND
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));

        // ALLOW METHODS (GET, POST, etc.)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ALLOW HEADERS (Content-Type for JSON, Authorization for tokens)
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        // Allow credentials (if you use cookies or headers)
        configuration.setAllowCredentials(true);



        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Apply this configuration to all routes
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}