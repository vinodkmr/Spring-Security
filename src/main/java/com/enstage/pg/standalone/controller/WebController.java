package com.enstage.pg.standalone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    
    @GetMapping("/home")
    public String showHome(){
        return "home";
    }
    


}
