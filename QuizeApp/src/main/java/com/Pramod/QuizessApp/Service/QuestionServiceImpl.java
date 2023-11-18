package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.QuestionDao;
import com.Pramod.QuizessApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public void save(Question theQuestion) {
        questionDao.save(theQuestion);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }


    @Override
    public Question findById(int questionId) {
        Optional<Question> result= questionDao.findById(questionId);
        Question theQuestion = null;
        if(result.isPresent()){
            theQuestion=result.get();
        }
        else {
            throw new RuntimeException("Did not find id: - "+questionId);
        }

        return theQuestion;
    }

    @Override
    public void deleteById(int questionId) {
        questionDao.deleteById(questionId);
    }
}
