package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.Service.UserService;
import com.Pramod.QuizessApp.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class Registration {
    private Logger logger = Logger.getLogger(getClass().getName());

    private final UserService userService;
    private char[] password;

    @Autowired
    public Registration(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/Registration")
    public String showLogin(Model theModel){
        theModel.addAttribute("webUser", new WebUser());

        System.out.println("Inside Registration...!");
        return "Login/RegistrationForm";
    }


    @PostMapping("/processRegistration")
    public String processRegistration(
            @Valid @ModelAttribute("webUser") WebUser theWebUser,
            BindingResult theBindingResult,
            HttpSession session, Model theModel){
        String userName = theWebUser.getUserName();
        logger.info("Processing registration form for; "+userName);
        ;
        if(theBindingResult.hasErrors()){
            System.out.println("Binding result has errors...!");
            return "Login/RegistrationForm";
        }
        if(theWebUser.getEmail() == null || theWebUser.getEmail().isEmpty()){
            theModel.addAttribute("webUser",new WebUser());
            theModel.addAttribute("RegistrationError","Email is required.");
            logger.warning("Email is required");
            return "Login/RegistrationForm";
        }
      //  if(theWebUser!=null|| theWebUser.setPassword();)

        User existing = userService.findByUserName(userName);
        if (existing!=null) {
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("Registration Error", "User name already exists..!");
            logger.warning("User already exists");

            return "Login/RegistrationForm";

        }
        userService.save(theWebUser);
        logger.info("User Created: "+userName);
        session.setAttribute("user",theWebUser);
        return "Login/RegistrationConfirmation";
    }
}
