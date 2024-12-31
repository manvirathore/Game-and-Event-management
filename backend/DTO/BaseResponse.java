package com.fitrack.demo.DTO;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BaseResponse {

    private String message;
    private LocalDateTime timestamp;
}
