package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
JWT implementation
	add JWTTokenGeneratorFilter class
	add JWTTokenValidatorFilter class

	add filter in ProjectSecurityConfig class and did some changes

	change in ui login.component.ts and app.interceptor.ts
 */

@SpringBootApplication
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
