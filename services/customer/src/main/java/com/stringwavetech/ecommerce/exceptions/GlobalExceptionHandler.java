package com.stringwavetech.ecommerce.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error(ex.getMessage(), ex.getDetails()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleInvalidFieldException(InvalidFieldException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error(ex.getMessage(), ex.getDetails()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleInvalidJson(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error("BAD_REQUEST", null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidOtpException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleInvalidOtp(InvalidOtpException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error(ex.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existing, replacement) -> existing
                ));

        log.warn("Validation error: {}", errors);

        return new ResponseEntity<>(
                BaseResponseModel.<Void>error("VALIDATION_ERROR", List.of(errors)),
                HttpStatus.BAD_REQUEST
        );
    }

    // --- 404 NOT FOUND ---

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleNoResourceFoundException(NoResourceFoundException ex) {
        log.warn("Resource not found: {}", ex.getMessage());
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error("NOT_FOUND",  null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error(ex.getMessage(), ex.getDetails()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(BaseResponseModel.error(ex.getMessage(), ex.getDetails()));
    }

    // --- 409 CONFLICT & 429 LIMITS ---

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleConflictException(ConflictException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error(ex.getMessage(), ex.getDetails()),
                HttpStatus.CONFLICT
        );
    }



    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<BaseResponseModel<Void>> handleServerErrorException(ServerErrorException ex) {
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error("UNEXPECTED_ERROR", ex.getDetails()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseModel<Void>> handleGenericException(Exception ex) {
        log.error("Unhandled exception occurred: ", ex);
        return new ResponseEntity<>(
                BaseResponseModel.<Void>error("UNEXPECTED_ERROR", null),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}