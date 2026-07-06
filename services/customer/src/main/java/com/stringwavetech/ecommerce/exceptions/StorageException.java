package com.stringwavetech.ecommerce.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class StorageException extends RuntimeException {

    private final List<String> details;

    public StorageException(String message, List<String> details) {
        super(message);
        this.details = details;
    }
}