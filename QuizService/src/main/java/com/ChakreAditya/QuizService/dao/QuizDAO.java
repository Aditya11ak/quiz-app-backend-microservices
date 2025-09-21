package com.ChakreAditya.QuizService.dao;


import com.ChakreAditya.QuizService.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz,Integer> {

}
