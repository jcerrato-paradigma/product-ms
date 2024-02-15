package com.inditex.ms.product.infrastructure.controller.error;

import com.inditex.ms.product.infrastructure.controller.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> genericExceptionHandler(Exception exception) {

        return getResponseEntityError(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Error> getResponseEntityError(Exception exception, HttpStatus httpStatus) {

        Error error = new Error();
        error.message(exception.getMessage());

        return new ResponseEntity<>(error, httpStatus);
    }
}
