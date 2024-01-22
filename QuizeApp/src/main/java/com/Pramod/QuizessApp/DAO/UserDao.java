package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.User;

import java.util.List;


public interface UserDao  {



    User findByUserName(String theUserName);
    void save(User theUser);

    List<User> findAll();

    //List<User> findAll();
}
