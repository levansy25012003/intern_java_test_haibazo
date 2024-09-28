package com.vn.product_service.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private List<ValidationError> validationErrors = new ArrayList<>();

    public void addValidationError(String field, String error) {
        validationErrors.add(new ValidationError(field, error));
    }

    @Data
    public static class ValidationError {
        private String field;
        private String error;

        public ValidationError(String field, String error) {
            this.field = field;
            this.error = error;
        }
    }
}
