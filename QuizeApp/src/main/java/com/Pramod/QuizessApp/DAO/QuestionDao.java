package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question>findByCategory(String category);
/*
    @Query(value = "SELECT * FROM QUESTION q WHERE q.category=:category ORDER BY RANDOM () LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);*/
@Query(value = "SELECT * FROM QUESTION q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
//http://localhost:8080/quize/create?category=Java&numQ=5&title=JQuize

    // Question saveQuestion(Question question);
}
