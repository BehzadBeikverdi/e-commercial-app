package com.stringwavetech.customer.exceptions;

import com.stringwavetech.customer.model.BaseResponseModel;
import lombok.Getter;

import java.util.List;

@Getter
public class IllegalArgumentException extends RuntimeException {
    private final BaseResponseModel<Void> response;

    public IllegalArgumentException(String message, List<String> details) {
        super(message);
        this.response = BaseResponseModel.error(message, details);
    }

}