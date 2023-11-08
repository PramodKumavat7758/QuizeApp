package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
