package com.ChakreAditya.QuestionService.dao;

import com.ChakreAditya.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question,Integer> {

    // for the method find by category in questionController
    List<Question> findByCategory(String category);


    // for getting random questions with count==numQ of category which every mentioned there
    @Query(value = "Select q.id from question q where q.category = :category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
