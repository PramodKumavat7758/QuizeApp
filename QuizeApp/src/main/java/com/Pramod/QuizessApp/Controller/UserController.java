package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.Service.QuestionService;
import com.Pramod.QuizessApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    // " userDashboard
    @GetMapping("/userDashboard")
    public String showDash(Model model){
       // Object questions;
        List<Question> questions = questionService.findAll();
         model.addAttribute("questions", questions);
         System.out.println("Iside shoDash User");
        return "User/userDashboard"; // This should be the name of your Thymeleaf template
    }

    // Profile Updating

    @GetMapping("/update_Profile")
    public String showProfile(@RequestParam("theUserName") String theUserName, Model model){
        User user = userService.findByUserName(theUserName);
        model.addAttribute("user",user );
        return "Login/RegistrationForm";
    }
    // Show the list of all registered user

    @GetMapping("/userList")
    public String showStudents(Model model){
        List<User> users= userService.findAll();
        model.addAttribute("users", users);
        System.out.println("Show Students...!");
        return "Admin/userList";

    }


}
