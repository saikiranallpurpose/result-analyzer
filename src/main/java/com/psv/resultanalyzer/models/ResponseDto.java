package com.psv.resultanalyzer.models;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ResponseDto {
    HttpStatus statusCode;
    String message;
    Object data;
}
