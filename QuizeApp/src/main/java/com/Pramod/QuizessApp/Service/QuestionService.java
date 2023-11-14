package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.Question;

import java.util.List;


public interface QuestionService {


    // Fetching all the questions from DB
   public List<Question> findAll();
}