package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public String updateQuestion(@RequestParam("questionId") int questionId, Model model){
        Question theQuestion = questionService.findById(questionId);
        model.addAttribute("questions", theQuestion);
        return "question/AddQuestion";
  }

  @GetMapping("/DeleteQuestion")
  public String deleteQuestion(@RequestParam("questionId") int questionId){
       questionService.deleteById(questionId);
      return "redirect:/question/List";
  }
  @PostMapping("/save")
    public String saveQuestion(@ModelAttribute("questions") Question theQuestion){
      questionService.save(theQuestion);
      return "redirect:/question/List";
  }


  // Attempting Logic



}
