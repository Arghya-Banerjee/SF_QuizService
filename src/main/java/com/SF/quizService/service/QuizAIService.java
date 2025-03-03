package com.SF.quizService.service;

import com.SF.quizService.dto.GeminiResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;

@Service
public class QuizAIService {

    // Access to API and API_KEY
    @Value("${GEMINI.API.URL}")
    private String apiUri;
    @Value("${GEMINI.API.KEY}")
    private String apiKey;

    private final WebClient webClient;

    public QuizAIService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public String askQuestion(String question){

        // Get question/payload
        Map<String, Object> payLoad = Map.of(
                "contents", new Object[]{
                        Map.of(
                                "parts", new Object[]{
                                        Map.of(
                                                "text", question
                                        )
                                }
                        )
                }
        );

        // Call API
        GeminiResponseDto response = webClient.post()
                .uri("")
                .header("Content-Type", "application/json")
                .bodyValue(payLoad)
                .retrieve()
                .bodyToMono(GeminiResponseDto.class)
                .block();

        // Return response from API
//        return response;
        return extractText(response);
    }

    private String extractText(GeminiResponseDto response) {
        if (response != null && response.getCandidates() != null && !response.getCandidates().isEmpty()) {
            return response
                    .getCandidates()
                    .get(0)
                    .getContent()
                    .getParts()
                    .get(0)
                    .getText()
                    .replace("\n", "");
        }
        return "No valid response from AI";
    }


}
