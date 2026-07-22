package com.stringwavetech.payment.exceptions;

import java.util.List;

public class InvalidFieldException extends RuntimeException {
    private final List<String> details;

    public InvalidFieldException(String message, List<String> details) {
        super(message);
        this.details = details;
    }

    public List<String> getDetails() {
        return details;
    }
}
