package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.Question;

import java.util.List;


public interface QuestionService {


    void save(Question theQuestion);


    // Fetching all the questions from DB
   public List<Question> findAll();
}