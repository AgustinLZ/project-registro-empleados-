package com.gestion.empleados;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GestionEmpleadosBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEmpleadosBackendApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false); // Allow cookies

        // TODO: Configure allowed origins (replace * with specific domains if needed)
        config.addAllowedOrigin("*");

        // Allow all methods
        config.addAllowedMethod("*");

        // Allow all headers
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
