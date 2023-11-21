package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.User;

public interface UserDao {
    User findByUserName(String userName);
    void save(User theUser);
}
