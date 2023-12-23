package com.Pramod.QuizessApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Admin {

    @GetMapping("/")
    public  String  showAdmin(){
           return "Admin/admin";
        }

      /*  @GetMapping("/userList")
        public String showStudents(Model model){
            List<User> users = UserService.findAll();
            model.addAttribute("users", users);
        return "Admin/userList";

        }*/




    }



