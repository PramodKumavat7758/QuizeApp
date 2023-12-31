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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public String showUser(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);


        return "User/user_List";
    }
}
