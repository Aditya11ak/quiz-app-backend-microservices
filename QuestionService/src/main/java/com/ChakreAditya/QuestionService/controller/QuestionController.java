package com.ChakreAditya.QuestionService.controller;

import com.ChakreAditya.QuestionService.model.Question;
import com.ChakreAditya.QuestionService.model.QuestionWrapper;
import com.ChakreAditya.QuestionService.model.Response;
import com.ChakreAditya.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    //getting all questions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //finding questions by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);

    }

    // adding question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    //updating question
    @PutMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.UpdateQuestion(question);
    }

    //deleting question
    @DeleteMapping("deleteQuestion/{Id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int Id){
        return questionService.deleteQuestion(Id);
    }

    // generating questions to give to quiz
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer noOFQuestions){
        return questionService.getQuestionsForQuiz(categoryName,noOFQuestions);
    }

    // get questions for the quiz for every id
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIDs){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromIDs(questionIDs);
    }

    // calculating score for the quiz
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

    // methods to implement in quizService
    //generate
    //getQuestion
    //getScore



}
