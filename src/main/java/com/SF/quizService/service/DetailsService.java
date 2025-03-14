package com.SF.quizService.service;

import com.SF.quizService.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    public String getSubtopicNameBySubtopicId(int subtopicid){
        return detailsRepository.getSubtopicNameBySubtopicId(subtopicid);
    }
}
