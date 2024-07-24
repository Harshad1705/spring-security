package com.harrySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/* 
custom filters
	change in EasyBankBackendApplication class
	change in appilcation.properties

	add RequestValidationBeforeFilter class
	change in ProjectSecurityConfig class

	add AuthoritiesLoggingAfterFilter class
	change in ProjectSecurityConfig class
	
	add AuthoritiesLoggingAtFilter class
	change in ProjectSecurityConfig class
*/

@SpringBootApplication
@EnableWebSecurity(debug=true)
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
 