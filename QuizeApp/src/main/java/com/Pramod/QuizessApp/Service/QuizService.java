package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.Model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

  /*  @Autowired
    QuestionDao questionDao;*/


    public List<Quiz> findAll() ;


    void save(Quiz theQuiz);

    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    Quiz getQuizById(int id);


    // Integer calculateResult(Integer id, List<Response> responses);

    //   String calculateResult(Integer id, List<Response> responses);

 /*  public default String create(String category, int numQ, String title){
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();

        return
    }*/
}

