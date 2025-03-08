package com.SF.quizService.service;

import com.SF.quizService.dto.*;
import com.SF.quizService.repository.QuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    private static final Logger logger = LoggerFactory.getLogger(QuizService.class);

    public List<GetQuestionsBySubtopicDto> getQuestionsBySubtopic(int opMode, int subtopicId){
        logger.info("getQuestionsBySubtopic called with parameters: opMode = {}, subtopicId = {}", opMode, subtopicId);
        return quizRepository.getQuestionsBySubtopic(opMode, subtopicId);
    }

    public Integer startQuizSession(int opMode, int studentId){
        logger.info("startQuizSession called with parameters: opMode = {}, studentId = {}", opMode, studentId);
        return quizRepository.startQuizSession(opMode, studentId);
    }

    public EndQuizDto endQuizSession(int opMode, int sessionId){
        logger.info("endQuizSession called with parameters: opMode = {}, sessionId = {}", opMode, sessionId);
        return quizRepository.endQuizSession(opMode, sessionId);
    }

    public void submitQuizAnswer(int opMode, int sessionId, QuizAnswerDto quizAnswerDto){
        logger.info("submitQuizAnswer called with parameters: opMode = {}, sessionId = {}, quizAnswerDto = {}", opMode, sessionId, quizAnswerDto.toString());
        quizRepository.submitQuizAnswer(
                opMode,
                sessionId,
                quizAnswerDto.getQuizId(),
                quizAnswerDto.getStudentAnswer()
        );
    }

    public List<QuizReportDto> viewQuizReport(int opMode, int sessionId){
        logger.info("viewQuizReport called with parameters: opMode = {}, sessionId = {}", opMode, sessionId);
        return quizRepository.viewQuizReport(opMode, sessionId);
    }

    public String getQuizAnalysis(int opMode, int sessionId){
        logger.info("getQuizAnalysis called with parameters: opMode = {}, sessionId = {}", opMode, sessionId);
        return quizRepository.getQuizAnalysis(opMode, sessionId);
    }

    public void insertQuizAnalysis(int opMode, int sessionId, String analysis){
        logger.info("insertQuizAnalysis called with parameters: opMode = {}, sessionId = {} and analysis", opMode, sessionId);
        quizRepository.insertQuizAnalysis(opMode, sessionId, analysis);
    }

    public List<QuizQuestionDto> getWrongSubmissions(int opMode, int sessionId){
        logger.info("getWrongSubmissions called with parameters: opMode = {}, sessionId = {}", opMode, sessionId);
        return quizRepository.getWrongSubmissions(opMode, sessionId);
    }

    public QuizQuestionDto getQuestionByQuizId(int opMode, int quizId){
        logger.info("getQuestionByQuizId called with parameters: opMode = {}, quizId = {}", opMode, quizId);
        return quizRepository.getQuestionByQuizId(opMode, quizId);
    }

    public String getSubtopicNameBySubtopicId(int opMode, int subtopicId){
        logger.info("getSubtopicNameBySubtopicId called with parameters: opMode = {}, subtopicId = {}", opMode, subtopicId);
        return quizRepository.getSubtopicNameBySubtopicId(opMode, subtopicId);
    }
}
