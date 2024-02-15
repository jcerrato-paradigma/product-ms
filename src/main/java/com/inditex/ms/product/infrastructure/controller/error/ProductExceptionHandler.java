package com.inditex.ms.product.infrastructure.controller.error;

import com.inditex.ms.product.domain.exception.ProductException;
import com.inditex.ms.product.infrastructure.controller.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Error> productExceptionHandler(ProductException exception) {

        return getResponseEntityError(
                exception,
                Optional.ofNullable(HttpStatus.resolve(exception.getHttpStatus()))
                        .orElse(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ResponseEntity<Error> getResponseEntityError(Exception exception, HttpStatus httpStatus) {

        Error error = new Error();
        error.message(exception.getMessage());

        return new ResponseEntity<>(error, httpStatus);
    }
}
