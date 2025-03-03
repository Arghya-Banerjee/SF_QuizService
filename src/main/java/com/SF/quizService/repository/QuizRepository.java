package com.SF.quizService.repository;

import com.SF.quizService.dto.EndQuizDto;
import com.SF.quizService.dto.GetQuestionsBySubtopicDto;
import com.SF.quizService.dto.QuizReportDto;
import com.SF.quizService.model.RootEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<RootEntity, Long> {


    @Query(value = "EXEC usp_QuizData @opMode = :opMode, @subtopicId = :subtopicId", nativeQuery = true)
    List<GetQuestionsBySubtopicDto> getQuestionsBySubtopic(
            @Param("opMode") int opMode,
            @Param("subtopicId") int subtopicId
    );

    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @studentId = :studentId", nativeQuery = true)
    Integer startQuizSession(
            @Param("opMode") int opMode,
            @Param("studentId") int studentId
    );

    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @sessionId = :sessionId", nativeQuery = true)
    EndQuizDto endQuizSession(
            @Param("opMode") int opMode,
            @Param("sessionId") int sessionId
    );

    @Modifying
    @Transactional
    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @sessionId = :sessionId, @quizId = :quizId, @studentAnswer = :studentAnswer", nativeQuery = true)
    void submitQuizAnswer(
            @Param("opMode") int opMode,
            @Param("sessionId") int sessionId,
            @Param("quizId") int quizId,
            @Param("studentAnswer") int studentAnswer
    );

    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @sessionId = :sessionId", nativeQuery = true)
    List<QuizReportDto> viewQuizReport(
            @Param("opMode") int opMode,
            @Param("sessionId") int sessionId
    );

    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @sessionId = :sessionId", nativeQuery = true)
    String getQuizAnalysis(
            @Param("opMode") int opMode,
            @Param("sessionId") int sessionId
    );

    @Modifying
    @Transactional
    @Query(value = "EXEC usp_QuizSession @opMode = :opMode, @sessionId = :sessionId, @analysis = :analysis", nativeQuery = true)
    void insertQuizAnalysis(
            @Param("opMode") int opMode,
            @Param("sessionId") int sessionId,
            @Param("analysis") String analysis
    );

}
