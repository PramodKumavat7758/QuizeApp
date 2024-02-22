package com.Pramod.QuizessApp.Security;

import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    public CustomAuthenticationSuccessHandler(UserService theUserService){
        userService = theUserService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       /* System.out.println("In CustomAuthenticationSuccessHandler");
        String userName = authentication.getName();
        //String userPass = (String) authentication.getCredentials();
        System.out.println("userName= " + userName);
        //System.out.println("userPass= "+userPass);
        User theUser = userService.findByUserName(userName);
        System.out.println("Before else condition");





        if (theUser.getRoles().equals("ROLE_ADMIN")) {
          //  System.out.println(theUser.getRoles() + userName);
            System.out.println("Inside Admin if condition");
            response.sendRedirect(request.getContextPath() + "/Admin");
        } else if (theUser.getRoles().equals("ROLE_STUDENT")) {
            response.sendRedirect(request.getContextPath() + "/Dashboard");
            System.out.println("Inside Student if condition");
            System.out.println(theUser.getRoles() + userName);
        } else {
            System.out.println("Admin Avoiaded");



            HttpSession session = request.getSession();
            response.sendRedirect(request.getContextPath() + "/");
        }*/


        System.out.println("In CustomAuthenticationSuccessHandler");
        String userName = authentication.getName();
        System.out.println("userName= " + userName);

        User theUser = userService.findByUserName(userName);
        if (theUser != null) {
            System.out.println("Before else condition");

            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

            boolean isStudent = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_STUDENT"));

            if (isAdmin) {
                System.out.println("Inside Admin if condition");
                response.sendRedirect(request.getContextPath() + "/Admin");
            } else if (isStudent) {
                System.out.println("Inside Student if condition");
                response.sendRedirect(request.getContextPath() + "/Dashboard");
            } else {
              //  System.out.println("Admin Avoided");
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            // Handle case where user is not found
            System.out.println("User not found");
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
