package com.harrySpringSecurity.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http.csrf(csrf->csrf.disable()).
                authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                                .requestMatchers("/notices", "/contact","/register").permitAll())
                                .formLogin(Customizer.withDefaults())
                                .httpBasic(Customizer.withDefaults())
                                .build();
        }

        // // In memory user detail authentication
        // @Bean
        // public InMemoryUserDetailsManager userDetailsService() {

        //         /*Approach 1 - where we use withDefaultPasswordEncoder() method
        //         while creating the user details */

        //         /* 
        //         UserDetails admin = User.withDefaultPasswordEncoder()
        //                 .username("admin")
        //                 .password("12345")
        //                 .authorities("admin")
        //                 .build();
        //         UserDetails user = User.withDefaultPasswordEncoder()
        //                 .username("user")
        //                 .password("12345")
        //                 .authorities("user")
        //                 .build();

        //         return new InMemoryUserDetailsManager(admin, user);
        //         */

        //         /*Approach 2 - where we use NoOpPasswordEncoder Bean
        //         while creating the user details */

        //         UserDetails admin = User.withUsername("admin")
        //                         .password("12345")
        //                         .authorities("admin")
        //                         .build();
        //         UserDetails user = User.withUsername("user")
        //                         .password("12345")
        //                         .authorities("user")
        //                          .build();

        //         return new InMemoryUserDetailsManager(admin, user);
        // }
 
        
        
        // jdbc style of authentication for inbuild user class
        // @Bean
        // public UserDetailsService userDetailsService(DataSource dataSource) {
        //         return new JdbcUserDetailsManager(dataSource);
        // }

        
        @Bean
        public PasswordEncoder PasswordEncoder() {
                // to store plain text password
                // return NoOpPasswordEncoder.getInstance();
                
                return new BCryptPasswordEncoder();
        }

}

