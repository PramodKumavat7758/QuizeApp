package com.Pramod.QuizessApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quize")
public class QuizeController {

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return new ResponseEntity<>("Url is working", HttpStatus.OK);

    }

}
