package com.SF.quizService.controller;

import com.SF.quizService.dto.*;
import com.SF.quizService.service.DetailsService;
import com.SF.quizService.service.QuizAIService;
import com.SF.quizService.service.QuizService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private QuizAIService quizAIService;
    @Autowired
    private DetailsService detailsService;

    private static final Logger logger = LoggerFactory.getLogger(QuizController.class);

    // To get questions for the quiz
    @GetMapping("/subtopic/{subtopicid}")
    public ResponseEntity<QuizDataDto> getQuestionsBySubtopic(@PathVariable int subtopicid){
        QuizDataDto quizData = quizService.getQuestionsBySubtopic(subtopicid);
        return ResponseEntity.ok(quizData);
    }

    // To start a quiz session
    @PostMapping("/start/{studentId}")
    public ResponseEntity<String> startQuizSession(@PathVariable int studentId, HttpSession session){
        Integer sessionId = quizService.startQuizSession(1, studentId);
        session.setAttribute("sessionId", sessionId);

        return ResponseEntity.ok("Quiz Session started successfully !!");
    }

    // To end a quiz session and give the sessionId to frontend
    @PutMapping("/end")
    public ResponseEntity<EndQuizDto> endQuizSession(HttpSession session){
        Integer sessionId = (Integer) session.getAttribute("sessionId");
        EndQuizDto endQuizData = quizService.endQuizSession(2, sessionId);
        session.removeAttribute("sessionId");

        return ResponseEntity.ok(endQuizData);
    }

    // To submit a quiz answer by student
    @PostMapping("/submit")
    public ResponseEntity<String> submitQuizAnswer(@RequestBody QuizAnswerDto quizAnswerDto, HttpSession session){
        Integer sessionId = (Integer) session.getAttribute("sessionId");
        quizService.submitQuizAnswer(3, sessionId, quizAnswerDto);

        return ResponseEntity.ok("Answer submitted succesfully !!");
    }

    // To generate full quiz Report
    @GetMapping("/viewReport/{sessionId}")
    public ResponseEntity<QuizAnalysisDto> viewQuizReport(@PathVariable int sessionId){
        List<QuizReportDto> answerList = quizService.viewQuizReport(4, sessionId);

        String analysis = quizService.getQuizAnalysis(5, sessionId);
        if(analysis == null){
            StringBuilder payload = new StringBuilder("Following are the questions with options along with the student answer and the correct answer option: " + "\n");
            for(QuizReportDto it: answerList){
                payload.append(
                        it.getQuestion() + "\n"
                                + "Option 1: " + it.getChoice1() + "\n"
                                + "Option 2: " + it.getChoice2() + "\n"
                                + "Option 3: " + it.getChoice3() + "\n"
                                + "Option 4: " + it.getChoice4() + "\n"
                                + "Student Answer option: " + it.getStudentAnswer() + "\n"
                                + "Correct Answer option: " + it.getCorrectAnswer() + "\n" + "\n"
                );
            }
            payload.append("Analyse the answers of the student and give a feedback on improvement areas in 50 words.");
            analysis = quizAIService.askQuestion(payload.toString());
            quizService.insertQuizAnalysis(6, sessionId, analysis);
        }
        QuizAnalysisDto quizAnalysis = new QuizAnalysisDto(answerList, analysis);

        return ResponseEntity.ok(quizAnalysis);
    }

    @GetMapping("/microlesson/{quizId}")
    public ResponseEntity<String> getMicroLession(@PathVariable int quizId){
        QuizQuestionDto question = quizService.getQuestionByQuizId(9, quizId);
        if(question == null){
            return new ResponseEntity<String>("Question does not exist!!", HttpStatus.NOT_FOUND);
        }
        logger.info(question.getQuestion());
        String microLesson = quizAIService.askQuestion(
                "Give a micro lesson for the following question within 80 words" +
                "\n" +
                question.getQuestion() +
                "Just give the lesson in one paragraph. If possible provide one example too"
        );
        return ResponseEntity.ok(microLesson);
    }

}
