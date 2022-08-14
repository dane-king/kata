package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhonebookController {
    private PhoneBookService phoneBookService;

    public PhonebookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping("/people")
    public String getPeople(){
        return phoneBookService.getPeople();
    }

}
