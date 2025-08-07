package com.smartpark.ratemypark.VisitorFeedback;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorFeedbackService {

    private final VisitorFeedbackRepository repository;

    public VisitorFeedbackService(VisitorFeedbackRepository repository) {
        this.repository = repository;
    }

    public VisitorFeedback addFeedback(VisitorFeedback feedback) {
        return repository.save(feedback);
    }

    public List<VisitorFeedback> getAllFeedback() {
        return repository.findAll();
    }

    public Optional<VisitorFeedback> getFeedbackById(Long id) {
        return repository.findById(id);
    }

    public VisitorFeedback updateStatus(Long id, String newStatus) {
        Optional<VisitorFeedback> feedbackOpt = repository.findById(id);
        if (feedbackOpt.isPresent()) {
            VisitorFeedback feedback = feedbackOpt.get();
            feedback.setStatus(newStatus);
            return repository.save(feedback);
        } else {
            throw new RuntimeException("Feedback not found");
        }
    }
}
