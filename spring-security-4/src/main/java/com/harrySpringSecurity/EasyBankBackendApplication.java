package com.harrySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
create a custom AuthenticationProvider so that we can use extra check on user like giving access to user have age more than X years ,etc .
*/

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
 