package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {


    public List<Quiz> findAll() ;


    void save(Quiz theQuiz);

    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    Quiz getQuizById(int id);



}

