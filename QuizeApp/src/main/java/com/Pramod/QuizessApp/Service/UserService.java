package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);
    void save (WebUser webUser);
}
