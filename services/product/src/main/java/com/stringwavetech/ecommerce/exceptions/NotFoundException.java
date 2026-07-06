package com.stringwavetech.ecommerce.exceptions;

import lombok.Getter;
import java.util.List;

@Getter
public class NotFoundException extends RuntimeException {
    private final List<String> details;

    public NotFoundException(String message) {
        super(message);
        this.details = null;
    }

    public NotFoundException(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}