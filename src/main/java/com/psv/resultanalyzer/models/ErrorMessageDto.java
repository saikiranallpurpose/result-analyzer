package com.psv.resultanalyzer.models;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorMessageDto {
    private String apiEndpoint;
    private HttpStatus statusCode;
    private String errorMessage;
    private LocalDateTime timestamp;
}
