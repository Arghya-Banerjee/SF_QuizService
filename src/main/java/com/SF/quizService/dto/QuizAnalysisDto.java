package com.SF.quizService.dto;

import java.util.List;

public class QuizAnalysisDto {
    private List<QuizReportDto> reportList;
    private String analysis;

    public QuizAnalysisDto() {
    }

    public QuizAnalysisDto(List<QuizReportDto> reportList, String analysis) {
        this.analysis = analysis;
        this.reportList = reportList;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public List<QuizReportDto> getReportList() {
        return reportList;
    }

    public void setReportList(List<QuizReportDto> reportList) {
        this.reportList = reportList;
    }
}
