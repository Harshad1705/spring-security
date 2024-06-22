package com.harrySpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
In memory user detail authentication
	- where we use withDefaultPasswordEncoder() method
	- where we use NoOpPasswordEncoder Bean while creating the user details

Jdbc style of authentication for inbuild user class

loadUserByUsername used to authentication for custom built class

Use Bcrypt password encoder
*/

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
		System.out.println("Started");
	}

}
 