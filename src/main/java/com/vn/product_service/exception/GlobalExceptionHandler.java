package com.vn.product_service.exception;

import com.vn.product_service.dto.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý ngoại lệ ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        // Tạo đối tượng ErrorResponse để trả về
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Validation error occurred");

        // Thêm các lỗi cụ thể từ ConstraintViolationException
        ex.getConstraintViolations().forEach(violation -> {
            errorResponse.addValidationError(violation.getPropertyPath().toString(), violation.getMessage());
        });

        // Trả về phản hồi với mã lỗi và thông tin lỗi
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
