package com.Pramod.QuizessApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_generator")
    @SequenceGenerator(name = "question_seq_generator", sequenceName = "question_seq", allocationSize = 1)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    // private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;
}
