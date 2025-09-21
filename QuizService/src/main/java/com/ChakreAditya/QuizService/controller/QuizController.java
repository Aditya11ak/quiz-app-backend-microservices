package com.ChakreAditya.QuizService.controller;


import com.ChakreAditya.QuizService.model.QuestionWrapper;
import com.ChakreAditya.QuizService.model.QuizDTO;
import com.ChakreAditya.QuizService.model.Response;
import com.ChakreAditya.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


    @Autowired
    QuizService quizService;

    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategoryName(),quizDTO.getNumQuestions(),quizDTO.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
       return quizService.getQuizQuestionsById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateRightAnswers(@PathVariable int id, @RequestBody List<Response> responses){
        return quizService.calculateAnswers(id,responses);
    }
}
