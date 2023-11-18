package com.Pramod.QuizessApp.Controller;

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

  @GetMapping("/CreateQuestion")
    public String addQuestion(Model model){
        Question theQuestion = new Question();
        model.addAttribute("questions", theQuestion);
        return "question/AddQuestion";
  }
  @GetMapping("/UpdateQuestion")
  public String updateQuestion(@RequestParam("questionId") int QId,  Model model){
        Question theQuestion = questionService.findAll().get(QId);
        model.addAttribute("questions",theQuestion);
        return "question/AddQuestion";
  }
  @PostMapping("/save")
    public String saveQuestion(@ModelAttribute("questions") Question theQuestion){
      questionService.save(theQuestion);
      return "redirect:/question/List";
  }


}
