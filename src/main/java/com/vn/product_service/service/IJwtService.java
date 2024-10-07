package com.vn.product_service.service;

import com.vn.product_service.model.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String generateToken(User user);
    String extractPhoneNumber(String token);
    boolean isTokenExpired(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
