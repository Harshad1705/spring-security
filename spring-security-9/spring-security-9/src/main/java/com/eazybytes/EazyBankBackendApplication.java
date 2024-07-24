package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/*
Method level Security
	-change requestMatcher of MyLoans to authenticated so we can 			  implement method level security
	- changes in EazyBankBackendApplication class

	- changes in LoanRepository class for PreAuthorize
	- changes in LoansControllers class for PostAuthorize
	
	- changes in ContactController class for PreFilter and Postfilter
	- change in ui in dashboard.service.ts and contact.component.ts

 */

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true , securedEnabled = true  , jsr250Enabled = true)
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
