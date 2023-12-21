package com.Pramod.QuizessApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class Admin {

    @GetMapping("/dashboard")
    public  String  showAdmin(Model model){
           return "Admin/admin";
        }
    }



