package com.SF.quizService.service;

import com.SF.quizService.dto.EndQuizDto;
import com.SF.quizService.dto.GetQuestionsBySubtopicDto;
import com.SF.quizService.dto.QuizAnswerDto;
import com.SF.quizService.dto.QuizReportDto;
import com.SF.quizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<GetQuestionsBySubtopicDto> getQuestionsBySubtopic(int opMode, int subtopicId){
        return quizRepository.getQuestionsBySubtopic(opMode, subtopicId);
    }

    public Integer startQuizSession(int opMode, int studentId){
        return quizRepository.startQuizSession(opMode, studentId);
    }

    public EndQuizDto endQuizSession(int opMode, int sessionId){
        return quizRepository.endQuizSession(opMode, sessionId);
    }

    public void submitQuizAnswer(int opMode, int sessionId, QuizAnswerDto quizAnswerDto){
        quizRepository.submitQuizAnswer(
                opMode,
                sessionId,
                quizAnswerDto.getQuizId(),
                quizAnswerDto.getStudentAnswer()
        );
    }

    public List<QuizReportDto> viewQuizReport(int opMode, int sessionId){
        return quizRepository.viewQuizReport(opMode, sessionId);
    }

    public String getQuizAnalysis(int opMode, int sessionId){
        return quizRepository.getQuizAnalysis(opMode, sessionId);
    }

    public void insertQuizAnalysis(int opMode, int sessionId, String analysis){
        quizRepository.insertQuizAnalysis(opMode, sessionId, analysis);
    }
}
