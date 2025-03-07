package com.SF.quizService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // ✅ Allow React frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // ✅ Allow all necessary HTTP methods
                .allowCredentials(true) // ✅ Allow cookies/session persistence
                .allowedHeaders("*") // ✅ Allow all headers
                .exposedHeaders("Set-Cookie"); // ✅ Allow Set-Cookie header to be exposed
    }
}
