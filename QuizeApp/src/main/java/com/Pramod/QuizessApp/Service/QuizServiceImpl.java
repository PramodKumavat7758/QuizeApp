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
}
