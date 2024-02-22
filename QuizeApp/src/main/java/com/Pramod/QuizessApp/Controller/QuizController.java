package com.Pramod.QuizessApp.Controller;

import com.Pramod.QuizessApp.Model.Question;
import com.Pramod.QuizessApp.Model.Quiz;
import com.Pramod.QuizessApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {
   // public static final Logger log = LoggerFactory.getLogger(LoggingPlayground.class);
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

        return "redirect:QuizList";
    }
// Getting quiz and questions

    @GetMapping("/attemptQuiz")
    public String attempt(Model model){
        List<Quiz> quizzes = quizService.findAll();
        model.addAttribute("quizzes", quizzes);
        return "question/quiz/attempt_Quiz_List";
    }


    @GetMapping("/{id}")
    public String getQuizQuestions(@PathVariable("id") int id,Model model){
        Quiz quiz = quizService.getQuizById(id);

        if(quiz!=null){
            List<Question> questions = quiz.getQuestions();
                model.addAttribute("questions",questions);
                model.addAttribute("quiz",quiz);
                model.addAttribute("quizTitle", quiz.getTitle());
               // model.addAttribute("response", responses);
        }
        return "User/attemptQuiz";
    }

    //Submitt quiz for evaluation
    @PostMapping("/submit")
    public String submitQuiz(@RequestParam("id") Integer quizId, @RequestParam Map<String,String> userResponses, Model model) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            List<Question> questions = quiz.getQuestions();

            int totalScore = calculateTotalScore(questions, userResponses);

            // Add the total score to the model
            model.addAttribute("totalScore", totalScore);
            // Add userResponses to the model (if needed)
            model.addAttribute("userResponses", userResponses);
        }
        // Return the view to display the result
        return "User/Result";
    }

    private int calculateTotalScore(List<Question> questions, Map<String, String> userResponses) {
        int totalScore = 0;
        for (Question question : questions) {
            String correctAnswer = question.getRightAnswer().toString(); // Assuming you have a method to retrieve the correct answer for each question
            String userResponse = userResponses.get(question.getId().toString());
           // System.out.println(userResponses);
            System.out.println(question);
            System.out.println(userResponse);
            if (userResponse != null && userResponse.equals(correctAnswer)) {
                totalScore++;
            }
        }
        return totalScore;
    }
}
