package com.stringwavetech.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BaseResponseModel<T> {
    private boolean success;
    private String message;
    private T payload;
    private List<?> errors;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime timestamp = LocalDateTime.now();

    public BaseResponseModel() {}

    public BaseResponseModel(boolean success, String message, T payload, List<?> errors, LocalDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.payload = payload;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    // Success
    public static <T> BaseResponseModel<T> success(String message, T payload) {
        return new BaseResponseModel<>(true, message, payload, null, LocalDateTime.now());
    }

    // Error
    public static <T> BaseResponseModel<T> error(String message, List<?> errors) {
        return new BaseResponseModel<>(false, message, null, errors, LocalDateTime.now());
    }
}