package com.psv.resultanalyzer.exception;

import com.psv.resultanalyzer.models.ErrorMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<ErrorMessageDto> handleResultException(ResultException ex, WebRequest webRequest) {
        log.error(ex.getMessage());
        ErrorMessageDto errorMessageDto = ex.getErrorMessageDto();
        return new ResponseEntity<>(
                ErrorMessageDto.builder()
                .apiEndpoint(webRequest.getDescription(false))
                .statusCode(errorMessageDto.getStatusCode())
                .errorMessage(errorMessageDto.getErrorMessage())
                .timestamp(LocalDateTime.now())
                .build(), errorMessageDto.getStatusCode());
    }
}
