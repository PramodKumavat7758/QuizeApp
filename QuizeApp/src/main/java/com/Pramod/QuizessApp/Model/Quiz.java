package com.Pramod.QuizessApp.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String quiz_category;
    private int Quiz_numQ;
    @ManyToMany
    private List<Question> questions;


    public Quiz(){}
    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public String getQuiz_category() {
        return quiz_category;
    }

    public void setQuiz_category(String quiz_category) {
        this.quiz_category = quiz_category;
    }

    public int getQuiz_numQ() {
        return Quiz_numQ;
    }

    public void setQuiz_numQ(int quiz_numQ) {
        Quiz_numQ = quiz_numQ;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
