package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.QuestionDao;
import com.Pramod.QuizessApp.DAO.QuizDao;
import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Model.QuestionWrapper;
import com.Pramod.QuizessApp.Model.Quiz;
import com.Pramod.QuizessApp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        //quiz.setId();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    // Returning the type of QuestionWrapper using this we fetching the Only questions and options
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    // Here calculating score comparing answers from client and DB
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int rightAns = 0, i = 0;
        for (Response response : responses){
            if (response.getResponse().equals(questions.get(i).getRightAnswer()));
            rightAns++;
            i++;
        }
        return new  ResponseEntity<>(rightAns, HttpStatus.OK);

    }
}
