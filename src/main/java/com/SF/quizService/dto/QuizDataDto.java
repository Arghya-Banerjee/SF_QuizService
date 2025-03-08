package com.SF.quizService.dto;

import java.util.List;

public class QuizDataDto {
    private List<GetQuestionsBySubtopicDto> questions;
    private String quizName;

    public QuizDataDto() {
    }

    public QuizDataDto(List<GetQuestionsBySubtopicDto> questions, String quizName) {
        this.questions = questions;
        this.quizName = quizName;
    }

    public List<GetQuestionsBySubtopicDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<GetQuestionsBySubtopicDto> questions) {
        this.questions = questions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
