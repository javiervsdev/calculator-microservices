package dev.javiervs.common.advice;

import dev.javiervs.common.dto.ApiError;
import dev.javiervs.common.exception.OperandException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.badRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(OperandException.class)
    public ResponseEntity<ApiError> handleOperandException(OperandException e) {
        log.error("Validation error", e);
        return badRequest()
                .body(new ApiError(
                        BAD_REQUEST.value(),
                        e.getMessage()));
    }
}
