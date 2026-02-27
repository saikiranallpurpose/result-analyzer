package com.psv.resultanalyzer.exception;

import com.psv.resultanalyzer.models.ErrorMessageDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ResultsError {
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "Invalid input provided"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred"),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "Requested data not found"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized access"),
    CUSTOMER_ALREADY_EXISTS(HttpStatus.CONFLICT, "Customer already exists: ${customerName}"),
    CUSTOMER_NOT_FOUND(HttpStatus.BAD_REQUEST, "Customer not found with mobile number: ${mobileNumber}"),
    ACCOUNT_NOT_FOUND(HttpStatus.BAD_REQUEST, "Account not found for Account Number : ${accountNumber}"),;

    ResultsError(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    private final HttpStatus statusCode;
    private final String message;

    public ResultException toException(String key, Object value) {
        return new ResultException(ErrorMessageDto.builder()
                .errorMessage(buildMessage(Map.of(key, value)))
                .statusCode(statusCode)
                .build());
    }

    public ResultException toException() {
        return new ResultException(ErrorMessageDto.builder()
                .errorMessage(this.message)
                .statusCode(statusCode)
                .build());
    }

    private String buildMessage(Map<String, Object> params) {
        String formattedMessage = this.message;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            formattedMessage = formattedMessage.replace("${" + entry.getKey() + "}", entry.getValue().toString());
        }
        return formattedMessage;
    }
}
