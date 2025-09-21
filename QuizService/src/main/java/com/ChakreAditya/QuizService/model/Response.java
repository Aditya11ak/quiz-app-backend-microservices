package com.ChakreAditya.QuizService.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private int id;
    private String response;
}
