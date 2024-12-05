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
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/member/**").hasRole("MEMBER")
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll  // Allow anyone to access the login page
                );

        return http.build();
    }
}