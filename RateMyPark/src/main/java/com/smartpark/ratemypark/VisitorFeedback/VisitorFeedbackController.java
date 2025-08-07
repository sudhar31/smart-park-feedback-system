package com.smartpark.ratemypark.VisitorFeedback;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class VisitorFeedbackController {

    private final VisitorFeedbackService service;

    public VisitorFeedbackController(VisitorFeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public VisitorFeedback addFeedback(@RequestBody VisitorFeedback feedback) {
        return service.addFeedback(feedback);
    }

    @GetMapping
    public List<VisitorFeedback> getAllFeedback() {
        return service.getAllFeedback();
    }

    @PutMapping("/{id}/status")
    public VisitorFeedback updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
