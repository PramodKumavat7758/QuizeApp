package com.Pramod.QuizessApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @GetMapping("/login")
    public String showLogin(){
        return "Login/login";
    }
@GetMapping("/accessDenied")
    public String accessDenied(){
        return "Login/acces-denied";
    }
}
