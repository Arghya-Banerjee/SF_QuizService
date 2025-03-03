package com.SF.quizService.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetQuestionsBySubtopicDto {

    private Integer quizId;
    private Integer subtopic;
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Integer answer;

    public GetQuestionsBySubtopicDto() {
    }

    public GetQuestionsBySubtopicDto(Integer quizId, String question, String choice1, String choice2, String choice3, String choice4) {
        this.quizId = quizId;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public GetQuestionsBySubtopicDto(Integer quizId, Integer subtopic, String question, String choice1, String choice2, String choice3, String choice4, Integer answer) {
        this.quizId = quizId;
        this.subtopic = subtopic;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Integer getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(Integer subtopic) {
        this.subtopic = subtopic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
