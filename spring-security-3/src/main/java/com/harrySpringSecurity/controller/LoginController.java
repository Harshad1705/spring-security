package com.harrySpringSecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.harrySpringSecurity.entity.Customers;
import com.harrySpringSecurity.repository.CustomerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> postMethodName(@RequestBody Customers customer) {

        Customers savedCustomer = null;

        ResponseEntity response = null;

        try {
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPwd);
            savedCustomer = customerRepository.save(customer);
            
            if(savedCustomer.getId()>0){
                response =ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registerd");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + e.getMessage());
        }
   
        return response;  
    }
    

}
