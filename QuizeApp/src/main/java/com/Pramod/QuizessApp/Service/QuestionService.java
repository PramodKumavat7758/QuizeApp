package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.Question;

import java.util.List;
import java.util.Optional;


public interface QuestionService {


    void save(Question theQuestion);


    // Fetching all the questions from DB
   public List<Question> findAll();



    Question findById(int questionId);

    void deleteById(int questionId);
}