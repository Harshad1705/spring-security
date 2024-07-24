package com.harrySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
change in database
handle cors
handle csrf
*/

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
 