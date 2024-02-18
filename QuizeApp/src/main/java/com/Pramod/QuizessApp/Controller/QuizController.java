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
    public String submitQuiz(@RequestParam Integer id, @RequestParam Map<String,String> userResponses, Model model) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            List<Question> questions = quiz.getQuestions();
            int totalScore = calculateResult(questions, userResponses);
            model.addAttribute("totalScore", totalScore);
            System.out.println("Inside the submit quiz if condition");
        } else {
            // Return appropriate HTTP status code (e.g., 404) to indicate quiz not found
            model.addAttribute("error", "Quiz Not Found");
        }
        System.out.println("Before result");
        return "User/Result";
    }

    private int calculateResult(List<Question> questions, Map<String,String> userResponses) {
       // Initialize total score to 0
        int totalScore = 0;
        for (Question question : questions) {
            String questionId = String.valueOf(question.getId());
            String userResponse = userResponses.getOrDefault(questionId, "").trim(); // Trim user response to handle whitespace
            System.out.println("Question ID: " + questionId); // Debug statement
          //  System.out.println("User Response: " + userResponse); // Debug statement

            if (!userResponse.isEmpty()) { // Check if user provided a response
                // Get the correct answer for the current question
                String correctAnswer = question.getRightAnswer();
                // Assuming single correct answer for simplicity
                if (userResponse.equalsIgnoreCase(correctAnswer)) {
                    totalScore++; // Increment total score for correct answer
                }

            }
        }
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }
/*
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        Integer score = quizService.calculateResult(id, responses);
        if (score == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if quiz not found
        }
        return new ResponseEntity<>(score, HttpStatus.OK); // Return the score
    }

*/

}
