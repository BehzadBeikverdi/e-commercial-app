package com.stringwavetech.payment.exceptions;

import java.util.Collections;
import java.util.List;

public class UnauthorizedException extends RuntimeException {

    private final List<String> details;

    public UnauthorizedException(String message) {
        super(message);
        this.details = Collections.singletonList(message);
    }

    public UnauthorizedException(String message, List<String> details) {
        super(message);
        this.details = Collections.unmodifiableList(details);
    }

    public List<String> getDetails() {
        return details;
    }
}
