package com.stringwavetech.payment.exceptions;

import lombok.Getter;
import java.util.List;

@Getter
public class BusinessException extends RuntimeException {
    private final List<String> details;

    public BusinessException(String message) {
        super(message);
        this.details = null;
    }

    public BusinessException(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}