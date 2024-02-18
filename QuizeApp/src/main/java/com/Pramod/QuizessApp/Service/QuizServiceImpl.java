package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.QuestionDao;
import com.Pramod.QuizessApp.DAO.QuizDao;
import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Quiz> findAll() {
        return quizDao.findAll();
    }

    @Override
    public void save(Quiz theQuiz) {
        quizDao.save(theQuiz);
    }

    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.CREATED);
    }

    @Override
    public Quiz getQuizById(int id) {
        Optional<Quiz> quizOptional = quizDao.findById(id);
        return quizOptional.orElse(null);
    }/*

    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).orElse(null);
        if (quiz == null) {
            // Handle the case where the quiz with the given ID is not found
            return null;
        }
        List<Question> questions = quiz.getQuestions();
        int rightAns = 0;
        for (int i = 0; i < Math.min(responses.size(), questions.size()); i++) {
            Response response = responses.get(i);
            if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
                rightAns++;
            }
        }
        return rightAns; // Return the score
    }*/



}
