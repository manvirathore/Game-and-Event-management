package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.FeedbackDTO;
import com.fitrack.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO feedback =  feedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>(feedback, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> getAllFeedback() {
        return new ResponseEntity<>(feedbackService.getAllFeedback(), HttpStatus.OK);
    }
}