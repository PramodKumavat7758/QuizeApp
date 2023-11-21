package com.Pramod.QuizessApp.Security;

import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;
    public CustomAuthenticationSuccessHandler(UserService theUserService){
        userService = theUserService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("In CustomAuthenticationSuccessHandler");
        String userName = authentication.getName();
        System.out.println("userName= "+userName);
        User theUser = userService.findByUserName(userName);
        HttpSession session = request.getSession();
        response.sendRedirect(request.getContextPath() + "/");
    }
}
