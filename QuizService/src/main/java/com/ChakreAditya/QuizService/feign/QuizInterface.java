package com.ChakreAditya.QuizService.feign;

import com.ChakreAditya.QuizService.model.QuestionWrapper;
import com.ChakreAditya.QuizService.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {

    // generating questions to give to quiz
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer noOFQuestions);

    // get questions for the quiz for every id
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIDs);

    // calculating score for the quiz
    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}