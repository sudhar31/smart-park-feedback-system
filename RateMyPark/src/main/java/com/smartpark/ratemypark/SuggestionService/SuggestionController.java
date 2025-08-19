package com.smartpark.ratemypark.SuggestionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
@CrossOrigin(origins = "*") // Allow frontend calls
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping
    public String generateSuggestion(@RequestBody String feedback) {
        return suggestionService.getSuggestion(feedback);
    }
}
