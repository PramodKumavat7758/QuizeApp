package com.Pramod.QuizessApp.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_generator")
    @SequenceGenerator(name = "question_seq_generator", sequenceName = "question_seq", allocationSize = 1)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    // private String option4;
    private String difficultylevel;
    private String category;
    private String rightAnswer;

    public Question(){}
    public Question(Integer id, String questionTitle, String option1, String option2, String option3, String difficultylevel, String category, String rightAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.difficultylevel = difficultylevel;
        this.category = category;
        this.rightAnswer = rightAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    public String setCategory(String category) {
        this.category = category;
        return category;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", difficultylevel='" + difficultylevel + '\'' +
                ", category='" + category + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }

}
