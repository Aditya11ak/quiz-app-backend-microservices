package com.ChakreAditya.QuizService.service;

import com.ChakreAditya.QuizService.dao.QuizDAO;
import com.ChakreAditya.QuizService.feign.QuizInterface;
import com.ChakreAditya.QuizService.model.QuestionWrapper;
import com.ChakreAditya.QuizService.model.Quiz;
import com.ChakreAditya.QuizService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer>  questions = quizInterface.generateQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(int id) {
        Optional<Quiz> optionalQuiz = quizDAO.findById(id);

        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Quiz quiz = optionalQuiz.get();
        List<Integer> questionIds = quiz.getQuestionIds();
        return quizInterface.getQuestionsById(questionIds);
    }

    public ResponseEntity<Integer> calculateAnswers(int id, List<Response> responses) {
        return quizInterface.getScore(responses);
    }

}
