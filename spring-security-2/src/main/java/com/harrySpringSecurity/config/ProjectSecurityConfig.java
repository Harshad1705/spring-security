package com.harrySpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
            .requestMatchers("/notices","/contact").permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    /* 
    // denying all the requests
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((
                requests) -> requests
                        .anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    */
    
    /* 
    // permit all the requests
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((
                requests) -> requests
                        .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    */
}