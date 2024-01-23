package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {



    User findByUserName(String theUserName);
    void save(WebUser webUser);

   public List<User> findAll();

    User findByUserId(int theUserId);
}
