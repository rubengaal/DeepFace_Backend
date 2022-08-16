package com.deepface.deepface.controllers;

import com.deepface.deepface.business.ImageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/test")
    public String  test() {
        //manager.InsertImage("hua", "1a5d1asda5dsa41df");
        return "200 OK";
    }

    @PostMapping("/generate")
    public String generateModel(@RequestBody String dataUrl) {
        //workflow trigger
        return "200 OK";
    }
}
