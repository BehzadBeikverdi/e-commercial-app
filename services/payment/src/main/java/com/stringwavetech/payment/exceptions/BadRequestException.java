package com.stringwavetech.payment.exceptions;

import lombok.Getter;
import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    private final List<String> details;

    public BadRequestException(String message) {
        super(message);
        this.details = null;
    }

    public BadRequestException(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}