package com.inditex.ms.product.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductException extends RuntimeException {

    private String message;
    private Throwable cause;

    private int httpStatus;

    public ProductException(String message, Throwable cause, int httpStatus) {

        super(message, cause);
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
    }
}
