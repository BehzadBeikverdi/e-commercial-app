package com.stringwavetech.ecommerce.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class IllegalStateException extends RuntimeException {

    private final List<String> details;

    public IllegalStateException(String message) {
        super(message);
        this.details = null;
    }

    public IllegalStateException(
            String message,
            List<String> details
    ) {
        super(message);
        this.details = details;
    }
}