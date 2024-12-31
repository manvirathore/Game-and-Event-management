package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.FeedbackDTO;
import com.fitrack.demo.model.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackDTO toDTO(Feedback feedback) {
        if (feedback == null) {
            return null;
        }

        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setId(feedback.getId());
        feedbackDTO.setEventId(feedback.getEventId());
        feedbackDTO.setFeedback(feedback.getFeedback());

        return feedbackDTO;
    }

    public Feedback toEntity(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null) {
            return null;
        }

        Feedback feedback = new Feedback();
        feedback.setId(feedbackDTO.getId());
        feedback.setEventId(feedbackDTO.getEventId());
        feedback.setFeedback(feedbackDTO.getFeedback());

        return feedback;
    }
}
