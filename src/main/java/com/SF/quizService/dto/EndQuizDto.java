package com.SF.quizService.dto;

public class EndQuizDto {
    private Integer obtainedMarks;
    private Integer fullMarks;
    private Integer sessionId;

    public EndQuizDto() {
    }

    public EndQuizDto(Integer obtainedMarks, Integer fullMarks, Integer sessionId) {
        this.obtainedMarks = obtainedMarks;
        this.fullMarks = fullMarks;
        this.sessionId = sessionId;
    }

    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public Integer getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Integer fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
}
