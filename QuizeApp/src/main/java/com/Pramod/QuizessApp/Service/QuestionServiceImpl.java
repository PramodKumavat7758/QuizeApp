package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.QuestionDao;
import com.Pramod.QuizessApp.DAO.QuizDao;
import com.Pramod.QuizessApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }
}
