package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for API endpoints
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**") // Disable CSRF for API requests
                )
                // Configure authorization for different paths
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Admin access restricted to users with ADMIN role
                        .requestMatchers("/member/**").hasRole("MEMBER")  // Member access restricted to users with MEMBER role
                        .requestMatchers("/public/**").permitAll()  // Public access allowed for all users
                        .requestMatchers("/api/**").permitAll()  // API endpoints open to everyone
                        .anyRequest().authenticated()  // Other requests require authentication
                )
                // Disabling form login for RESTful API access
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll); // Allow access to login page for form-based auth

        return http.build();
    }
}