package com.harrySpringSecurity.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetail() {
        return "Here are the account detail from the DB";
    }

}
