package com.Pramod.QuizessApp.Controller;


import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class Admin {

    @Autowired
    UserService userService;
/*    @GetMapping("/")
    public  String  showAdmin(){
           return "Admin/admin";
        }

      /*  @GetMapping("/userList")
        public String showStudents(Model model){
            List<User> users = UserService.findAll();
            model.addAttribute("users", users);
        return "Admin/userList";

        }
    @GetMapping("/Home")
    public String showHome(){
        return "Admin/home";
      }


*/
    @GetMapping("/userList")
    public String showStudents(Model model){
        List<User> users= userService.findAll();
        model.addAttribute("users", users);
        return "Admin/userList";

     }


    }



