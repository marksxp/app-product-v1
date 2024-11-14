package com.sxp.app.product.v1.domain.exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message) {
        super(message);
    }

}
