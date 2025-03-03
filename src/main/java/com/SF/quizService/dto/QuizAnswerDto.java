package com.SF.quizService.dto;

public class QuizAnswerDto {
    private int quizId;
    private int studentAnswer;  // skip = 0 else option number

    public QuizAnswerDto() {
    }

    public QuizAnswerDto(int quizId, int studentAnswer) {
        this.quizId = quizId;
        this.studentAnswer = studentAnswer;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(int studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
}
