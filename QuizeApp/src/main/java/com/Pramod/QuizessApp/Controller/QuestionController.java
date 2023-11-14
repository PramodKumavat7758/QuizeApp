package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.DAO.QuestionDao;
import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService theQuestionService){
        questionService=theQuestionService;
    }
  @GetMapping("/List")
  public String getAllQuestions(Model model) {
      List<Question> questions = questionService.findAll();
      model.addAttribute("questions", questions);
      return "question/QuestionList"; // This should be the name of your Thymeleaf template
  }

  @GetMapping("/Add")
    public String addQuestion(Model model){
        Question theQuestion = new Question();
        model.addAttribute("questions", theQuestion);
        return "question/AddQuestion";
  }


}
