package com.fitrack.demo.service;

import com.fitrack.demo.DTO.FeedbackDTO;
import com.fitrack.demo.Mapper.FeedbackMapper;
import com.fitrack.demo.model.Feedback;
import com.fitrack.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackMapper feedbackMapper;

    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.toEntity(feedbackDTO);
        return feedbackMapper.toDTO(feedbackRepository.save(feedback));
    }

    public List<FeedbackDTO> getAllFeedback() {
        return feedbackRepository.findAll().stream()
                .map(feedbackMapper::toDTO)
                .collect(Collectors.toList());
    }
}
