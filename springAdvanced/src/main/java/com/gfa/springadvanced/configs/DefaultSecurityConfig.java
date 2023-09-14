package com.gfa.springadvanced.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
@Configuration
public class DefaultSecurityConfig {


    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/login", "/register").permitAll() // Define URL patterns accessible without authentication
                .anyRequest().authenticated();

    }



    // Create an encoder with strength 16
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//    String result = encoder.encode("myPassword");
//    assertTrue(encoder.matches("myPassword", result));

    //ChatGPT
    /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("username")
                .password(passwordEncoder().encode("password"))
                .roles("USER");
    }*/


}