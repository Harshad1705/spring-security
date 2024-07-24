package com.harrySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
set authorities to customer 
	- change in EazyBankUsernamePwdAuthenticationProvider class
	- change in ProjectSecurityConfig class
*/

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
 