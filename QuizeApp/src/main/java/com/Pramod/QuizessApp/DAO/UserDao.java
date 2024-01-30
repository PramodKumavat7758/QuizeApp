package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.User;

import java.util.List;


public interface UserDao {



    User findByUserName(String theUserName);
    void save(User theUser);

    List<User> findAll();

    User findByUserId(int theUserId);

    void deleteById(int theUserId);

    //List<User> findAll();
}
