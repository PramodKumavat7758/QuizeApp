package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.Quiz;
import com.Pramod.QuizessApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/CreateNewQuiz")
    public String showCreatQuizForm(Model model){
        Quiz quize = new Quiz();
        model.addAttribute("quiz", quize);
        System.out.println("Inside the Create New Quize");


        return "question/quiz/AddQuiz";
    }


    @PostMapping("/saveQuiz")
    public String createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title, Model model){
        ResponseEntity<String> response = quizService.createQuiz(category, numQ, title);

        model.addAttribute("message",response.getBody());

        System.out.println("Inside save Quize");

        return "redirect:question/quiz/quizList";
    }

}
