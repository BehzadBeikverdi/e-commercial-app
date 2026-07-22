package com.stringwavetech.payment.exceptions;

public class KeycloakClientException extends RuntimeException {
    public KeycloakClientException(String message) {
        super(message);
    }

    public KeycloakClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
