package com.example.demo.successResponseAndErrorResponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    private String status;
    private String exception;
    private Boolean success;
    private List<String> details;
    private LocalDateTime dateTime;

    // Constructor with fields for error response
    public ErrorResponse(String exception, List<String> details) {
        this.status = "ERROR"; // Set default status value
        this.exception = exception;
        this.details = details;
        this.dateTime = LocalDateTime.now();
        this.success = Boolean.FALSE; // Indicating the failure status
    }
}
