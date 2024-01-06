package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.Quiz;
import com.Pramod.QuizessApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/QuizList")
    public String showAllquiz(Model model){
        List<Quiz> quizzes = quizService.findAll();
        model.addAttribute("quizzes", quizzes);
        return "question/quiz/quizList";
    }
    @GetMapping("/CreateQuiz")
    public String addQuiz(Model model){
        Quiz theQuiz = new Quiz();
        model.addAttribute("quizes", theQuiz);
        return "question/quiz/AddQuiz";
    }
    @PostMapping("/saveQuiz")
    public String save(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        quizService.create(category,numQ,title);
        return "redirect:question/quiz/quizList";
    }

}
