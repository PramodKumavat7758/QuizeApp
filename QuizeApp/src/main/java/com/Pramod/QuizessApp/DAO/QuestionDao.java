package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ" , nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String quiz_category, int Quiz_numQ);
}
