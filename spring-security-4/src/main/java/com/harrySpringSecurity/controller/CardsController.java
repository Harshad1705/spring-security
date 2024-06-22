package com.harrySpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String saveContactInquiryDetails() {
        return "Here are the card detail from the DB";
    }

}
