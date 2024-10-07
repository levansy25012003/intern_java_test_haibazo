package com.vn.product_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
    @NotBlank( message = "Phone number is not required")
    private String phoneNumber;

    @NotBlank( message = "Password is not required")
    private String password;
}
