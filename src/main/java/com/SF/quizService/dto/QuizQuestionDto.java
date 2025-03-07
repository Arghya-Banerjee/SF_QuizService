package com.SF.quizService.dto;

public class QuizQuestionDto {

    private int quizId;
    private String question;

    public QuizQuestionDto() {
    }

    public QuizQuestionDto(int quizId, String question) {
        this.quizId = quizId;
        this.question = question;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
