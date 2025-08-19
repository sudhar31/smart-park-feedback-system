package com.smartpark.ratemypark.SuggestionService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SuggestionService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String FLASK_API_URL = "http://localhost:5001/suggest";

    public String getSuggestion(String feedback) {
        try {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("feedback", feedback);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(FLASK_API_URL, entity, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return (String) response.getBody().get("suggestion");
            } else {
                return "Unable to get suggestion.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
