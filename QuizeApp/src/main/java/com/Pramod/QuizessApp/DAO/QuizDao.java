package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
   // String submit(Quiz quiz);


    //List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
}

