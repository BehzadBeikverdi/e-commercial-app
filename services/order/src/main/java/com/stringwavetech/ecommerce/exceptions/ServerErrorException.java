package com.stringwavetech.ecommerce.exceptions;

import lombok.Getter;
import java.util.List;

@Getter
public class ServerErrorException extends RuntimeException {
    private final List<String> details;

    public ServerErrorException(String message) {
        super(message);
        this.details = null;
    }

    public ServerErrorException(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}