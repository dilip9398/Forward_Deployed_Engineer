package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    private MessageHistroy messageHistroy;



    @PostMapping(value = "/message", consumes = "text/plain", produces = "text/plain")
    public String ServiceController(@RequestBody String message){
        return messageHistroy.message(message);
    }
}
