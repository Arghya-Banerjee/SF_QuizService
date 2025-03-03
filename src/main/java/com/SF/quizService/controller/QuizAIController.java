package com.SF.quizService.controller;

import com.SF.quizService.service.QuizAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/quizai")
public class QuizAIController {

    @Autowired
    private QuizAIService quizAIService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> body){
        String question = body.get("question");
        String answer = quizAIService.askQuestion(question);
        return ResponseEntity.ok(answer);
    }

}
