package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    public SummarizeService summarizeService;

    @PostMapping("summary")
    public String summarize(@RequestBody String ticket){

        return summarizeService.summarize(ticket);
    }



}
