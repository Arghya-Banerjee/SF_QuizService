package com.SF.quizService.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository {
    @Query(value = "EXEC usp_GetDetails @opMode = 4, @subtopicId = :subtopicId", nativeQuery = true)
    String getSubtopicNameBySubtopicId(
            @Param("subtopicId") int subtopicId
    );
}
