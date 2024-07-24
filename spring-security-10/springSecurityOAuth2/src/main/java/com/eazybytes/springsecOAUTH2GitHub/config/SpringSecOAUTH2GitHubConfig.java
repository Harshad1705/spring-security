package com.eazybytes.springsecOAUTH2GitHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> requests.requestMatchers("/secure").authenticated()
                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }

    /*
    
    @Bean
    public ClientRegistrationRepository clientRepository() {
        ClientRegistration github = githubClientRegistration();
        ClientRegistration facebook = facebookClientRegistration();
        return new InMemoryClientRegistrationRepository(github,facebook);
    }

    private ClientRegistration githubClientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("8cf67ab304dc500092e3")
                .clientSecret("6e6f91851c864684af2f91eaa08fb5041162768e").build();
    }
     
    private ClientRegistration facebookClientRegistration() {
		return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook").clientId("8cf67ab304dc500092e3")
	           .clientSecret("6e6f91851c864684af2f91eaa08fb5041162768e").build();
	 }
                
     */

}
