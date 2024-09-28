package com.vn.product_service.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T>{
    private int statusCode;
    private String message;
    private T data;
}
