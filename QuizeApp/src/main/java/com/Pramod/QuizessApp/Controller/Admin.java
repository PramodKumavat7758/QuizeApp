package com.Pramod.QuizessApp.Controller;


import com.Pramod.QuizessApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {

    @Autowired
    UserService userService;



    @GetMapping("/Admin")
    public  String  showAdmin(){


           return "Admin/admin";
        }



    @GetMapping("/Dashboard")
    public String showStudentDash(){return "User/userDashboard";}
}



