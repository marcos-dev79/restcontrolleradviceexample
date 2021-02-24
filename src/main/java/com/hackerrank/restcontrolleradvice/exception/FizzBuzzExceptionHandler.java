package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    // FizzException
    @ExceptionHandler(FizzException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalError handleFizzException(FizzException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }

    // BuzzException
    @ExceptionHandler(BuzzException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public GlobalError handleBuzzException(BuzzException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }

    // FizzBuzzException
    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
    public GlobalError handleFizzBuzzException(FizzBuzzException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }

}
