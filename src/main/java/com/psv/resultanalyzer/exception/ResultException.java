package com.psv.resultanalyzer.exception;

import com.psv.resultanalyzer.models.ErrorMessageDto;
import lombok.Getter;

@Getter
public class ResultException extends RuntimeException {
    private ErrorMessageDto errorMessageDto;

    public ResultException(String message) {
        super(message);
    }

    public ResultException(ErrorMessageDto errorMessageDto) {
        super(errorMessageDto.getErrorMessage());
        this.errorMessageDto = errorMessageDto;
    }
}
