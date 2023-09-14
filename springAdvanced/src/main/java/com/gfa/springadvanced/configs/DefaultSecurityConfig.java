package com.gfa.springadvanced.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class DefaultSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/register").permitAll()
              .requestMatchers("/movies", "/movies/findall").authenticated())
                .csrf((csrf) -> csrf.disable());
//               .requestMatchers("/movies", "/movies/findall", "/register").permitAll());
//                .anyRequest().permitAll());
//                http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                        .csrf((csrf) -> csrf
//                                .ignoringRequestMatchers("/api/*")
//                        );
//                        .csrf((csrf) -> csrf.disable());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}